package gold.problem1027;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        int N = Integer.parseInt(br.readLine());
        int[] buildings = getBuildings(br, N);

        answer = getAnswer(answer, N, buildings);
        System.out.println(answer);
    }

    private static int getAnswer(int answer, int N, int[] buildings) {
        for (int i = 0; i < N; i++) {
            int count = 0;

            for (int j = 0; j < N; j++) {
                if(i == j) continue;
                long slopeA = Math.abs(i - j); //기울기
                long slopeB = Math.abs(buildings[i] - buildings[j]); //기울기 2
                int constant = Math.min(buildings[i], buildings[j]); // 상수

                int minX = Math.min(i, j);
                int maxX = Math.max(i, j);

                int minY = buildings[i] > buildings[j] ? j : i;
                int maxY = buildings[i] > buildings[j] ? i : j;

                boolean tempVisible = true;
                for (int k = minX + 1; k < maxX; k++) {
                    if (slopeA * (buildings[k] - constant) >= slopeB * Math.abs(k-minY)) {
                        // 사이에 아무것도 걸리면 안됨.
                        tempVisible = false;
                        break;
                    }
                }
                if(tempVisible) {
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }


    private static int[] getBuildings(BufferedReader br, int N) throws IOException {
        int[] buildings = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }
        return buildings;
    }
}
