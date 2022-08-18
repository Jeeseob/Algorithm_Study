package gold.problem2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/08/19
 * @Problem : https://www.acmicpc.net/problem/2110
 */

public class Main {
    private static int houses[];
    private static int N, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int min = 0;
        int max = houses[N-1];
        while (min <= max) {
            int count = 1;
            int minHouse = 0;

            int average = (min + max) / 2;
            for (int i = 1; i < N; i++) {
                if (houses[i] - houses[minHouse] >= average) {
                    minHouse = i;
                    count++;
                }
            }

            if (count >= C) {
                min = average + 1;
            } else {
                max = average - 1;
            }
        }
        System.out.println(max);
    }
}
