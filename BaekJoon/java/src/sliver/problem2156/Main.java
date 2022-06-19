package sliver.problem2156;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] drinks = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            drinks[i] = Integer.parseInt(br.readLine());
        }
        // 초기값 세팅( N이 1,2 일 때 ArrayIndex오류 발생)
        dp[0] = drinks[0];

        if(N >= 2) {
            dp[1] = dp[0] + drinks[1];
        }
        if(N >= 3) {
            dp[2] = Math.max(dp[1], Math.max(dp[0] + drinks[2], drinks[1] + drinks[2]));
        }

        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + drinks[i], dp[i - 3] + drinks[i] + drinks[i - 1]));
        }

        System.out.println(dp[N-1]);
    }
}
