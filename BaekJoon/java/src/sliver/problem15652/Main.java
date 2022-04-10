package sliver.problem15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        readConsole();

        int[] answers = new int[M];
        calc(answers, 0, 1, stringBuilder);
        print(stringBuilder);
    }
    private static void calc(int[] answers, int tempIndex, int tempAnswer, StringBuilder stringBuilder) {
        if (tempIndex == M) {
            for(int answer : answers) {
                stringBuilder.append(answer + " ");
            }
            stringBuilder.append("\n");
            answers[M-1] = 0;
            return;
        }

        for (int i = tempAnswer; i <= N; i++) {
            answers[tempIndex] = i;
            calc(answers, tempIndex+1, i, stringBuilder);
        }
    }

    private static void print(StringBuilder stringBuilder) {
        System.out.println(stringBuilder);
    }

    private static void readConsole() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }
}
