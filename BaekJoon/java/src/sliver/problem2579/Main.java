package sliver.problem2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/08/27
 * @Problem : https://www.acmicpc.net/problem/2579
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] data = new int[N];
        int[] dynamcic = new int[N];

        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        if (N < 3) {
            System.out.println(Arrays.stream(data).sum());
            System.exit(0);
        }

        dynamcic[0] = data[0];
        dynamcic[1] = data[0] + data[1];
        dynamcic[2] = Math.max(data[0], data[1]) + data[2];

        for (int i = 3; i < N; i++) {
            dynamcic[i] = Math.max(dynamcic[i - 3] + data[i - 1], dynamcic[i - 2]) + data[i];
        }

        System.out.println(dynamcic[N - 1]);
    }
}