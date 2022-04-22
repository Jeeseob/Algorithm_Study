package sliver.problem12852;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] befores;
    private static int[] counts;
    private static int N;
    public static void main(String[] args) throws IOException {
        readConsole();
        if (!checkOne()) {
            initArrays();
            calc();
            print(checkAnswer());
        }
    }

    private static Boolean checkOne() {
        if(N == 1) {
            System.out.println(0 + "\n" + 1);
            return true;
        }
        return false;
    }

    private static void print(Stack<Integer> answerStack) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(counts[1] + "\n");
        while(!answerStack.isEmpty()) {
            stringBuilder.append(answerStack.pop() + " ");
        }
        System.out.println(stringBuilder);
    }

    private static Stack<Integer> checkAnswer() {
        Stack<Integer> answerStack = new Stack<>();
        int temp = 1;
        while(true) {
            if(temp == N) break;
            answerStack.add(temp);
            temp = befores[temp];
        }
        answerStack.add(N);
        return answerStack;
    }

    private static void calcArray(int nextNumber, int tempNumber, int count, Queue<Data> numbers) {
        befores[nextNumber] = tempNumber;
        counts[nextNumber] = count;
        numbers.add(new Data(nextNumber, count));
    }

    private static void calc() {
        Queue<Data> numbers = new LinkedList<>();
        numbers.add(new Data(N,0));

        while (!numbers.isEmpty()) {
            Data temp = numbers.poll();
            if(temp.number == 1) {
                break;
            }

            if(counts[temp.number - 1] > temp.count + 1) {
                calcArray(temp.number - 1, temp.number, temp.count + 1, numbers);
            }

            if (temp.number % 3 == 0 && counts[temp.number / 3] > temp.count + 1) {
                calcArray(temp.number / 3, temp.number, temp.count + 1, numbers);
            }

            if (temp.number % 2 == 0 && counts[temp.number / 2] > temp.count + 1) {
                calcArray(temp.number / 2, temp.number, temp.count + 1, numbers);
            }
        }
    }

    private static void initArrays() {
        befores = new int[N+1];
        counts = new int[N+1];
        Arrays.fill(counts, Integer.MAX_VALUE);
    }

    private static void readConsole() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }

    private static class Data {
        private int number;
        private int count;

        public Data(int number, int count) {
            this.number = number;
            this.count = count;
        }

        public int getNumber() {
            return number;
        }

        public int getCount() {
            return count;
        }
    }
}



// N만큼 Array를 만든다.

// 각 값에 대한 이전 값과 count를 적는다.

// count가 작아지면, 수정한다.

// 1에 가장먼저 도달한 경우를 찾아 거기서 부터 linked List처럼 재귀로 찾아들어간다.
// 1에서 부터 stack으로 저장한 후 빼내면, 정렬되어 나온다.

