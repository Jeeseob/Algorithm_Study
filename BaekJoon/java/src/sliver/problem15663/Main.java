package sliver.problem15663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static int[] numbers;
    private static int[] beforeList;

    static LinkedHashSet<String> answer;

    public static void main(String[] args) throws IOException {
        readConsole();

        int[] tempAnswer = new int[M];
        beforeList = new int[N];
        answer = new LinkedHashSet<>();

        calc(tempAnswer, 0);
        answer.forEach(System.out::println);
    }

    private static void calc(int[] tempAnswer,int tempIndex) {
        if (tempIndex == M) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < M; i++) {
                stringBuilder.append(tempAnswer[i] + " ");
            }
            answer.add(stringBuilder.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            if(beforeList[i] == 1) continue;
            tempAnswer[tempIndex] = numbers[i];
            beforeList[i] = 1;
            calc(tempAnswer, tempIndex + 1);
            beforeList[i] = 0;
        }
    }

    private static void readConsole() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        getNumbers(bufferedReader);
    }

    private static void getNumbers(BufferedReader bufferedReader) throws IOException {
        numbers = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(numbers);
    }
}
