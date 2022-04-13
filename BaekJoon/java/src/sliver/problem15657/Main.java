package sliver.problem15657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static int[] numbers;
    private static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {
        readConsole();
        stringBuilder = new StringBuilder();
        int[] answer = new int[M];
        calc(answer, 0, 0);
        System.out.println(stringBuilder);
    }

    private static void calc(int[] answer,int tempIndex, int lastNumberIndex) {
        if (tempIndex == M) {
            for (int i = 0; i < M; i++) {
                stringBuilder.append(answer[i] + " ");
            }
            stringBuilder.append('\n');
            return;
        }

        for (int i = lastNumberIndex; i < N; i++) {
            answer[tempIndex] = numbers[i];
            calc(answer, tempIndex + 1, i);
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
