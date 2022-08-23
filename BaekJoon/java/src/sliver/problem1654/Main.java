package sliver.problem1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/08/22
 * @Problem : https://www.acmicpc.net/problem/1654
 */

public class Main {
    private static long[] lines;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        lines = new long[K];
        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lines);
        long min = 1;
        long max = lines[lines.length-1];

        while (min <= max) {
            long mid = (max + min) / 2;
            if (check(mid) >= N) {
                min = mid + 1;
            }
            else {
                max = mid - 1;
            }
        }
        System.out.println(max);
    }

    public static long check(long mid) {
        return Arrays.stream(lines).map(i -> i/mid).sum();
    }
}
