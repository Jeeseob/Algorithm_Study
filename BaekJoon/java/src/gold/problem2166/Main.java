package gold.problem2166;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] xPos = new int[N+1];
        int[] yPos = new int[N+1];

        getPosition(br, N, xPos, yPos);
        double answer = clacAnswer(N, xPos, yPos);
        print(answer);

    }

    private static void getPosition(BufferedReader br, int N, int[] xPos, int[] yPos) throws IOException {
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            xPos[i] = Integer.parseInt(st.nextToken());
            yPos[i] = Integer.parseInt(st.nextToken());
        }
        xPos[N] = xPos[0];
        yPos[N] = yPos[0];
    }

    private static double clacAnswer(int N, int[] xPos, int[] yPos) {
        long sumPlus = 0;
        long sumMinus = 0;

        for (int i = 0; i < N; i++) {
            sumPlus += (long) xPos[i] * yPos[i + 1];
            sumMinus += (long) yPos[i] * xPos[i + 1];
        }
        return Math.abs(sumPlus - sumMinus) / 2.0;
    }

    private static void print(double tempAnswer) {
        String answer = String.format("%.1f", (tempAnswer));
        System.out.println(answer);
    }
}
