package sliver.problem15666;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;

    private static Integer[] numbers;
    static LinkedHashSet<String> answer;


    public static void main(String[] args) throws IOException {
        numbers = readConsole();

        answer = new LinkedHashSet<>();
        int[] tempAnswer = new int[M];
        calc(tempAnswer, 0, 0);

        answer.forEach(System.out::println);
    }

    private static void calc(int[] tempAnswer,int tempIndex, int beforeNumberIndex) {
        if (tempIndex == M) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < M; i++) {
                stringBuilder.append(tempAnswer[i] + " ");
            }
            answer.add(stringBuilder.toString());
            return;
        }

        for (int i = beforeNumberIndex; i < numbers.length; i++) {
            tempAnswer[tempIndex] = numbers[i];
            calc(tempAnswer, tempIndex + 1, i);
        }
    }

    private static Integer[] readConsole() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        return getNumbers(bufferedReader);
    }

    private static Integer[] getNumbers(BufferedReader bufferedReader) throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        LinkedHashSet<Integer> tempNumbers = new LinkedHashSet<>();
        for (int i = 0; i < N; i++) {
            tempNumbers.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        Integer[] numberArray = Arrays.stream(tempNumbers.toArray())
                .map(o -> (Integer) o)
                .toArray(Integer[]::new);


        Arrays.sort(numberArray);

        return numberArray;
    }
}
