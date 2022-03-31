package sliver.problem15650;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

    public static int[] tempSequence;
    public static int N, M;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        readConsole();
        tempSequence = new int[M];

        calcSequence(1, 0);

        System.out.println(sb.toString());
    }

    public static void calcSequence(int at, int depth) {
        if (depth == M) {
            for (int temp : tempSequence) {
                sb.append(temp + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i <= N; i++) {
            tempSequence[depth] = i;
            calcSequence(i + 1, depth + 1);
        }
    }

    private static void readConsole() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }
}