package gold.problem2098;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = 16 * 1_000_000;

    private static int FullBit;
    private static int N;

    private static int[][] dp;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // bit masking 1111...
        FullBit = (1<<N) - 1;

        map = new int[N][N];
        dp = new int[N][FullBit];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], INF);
        }

        getMap(br);

        System.out.println(calcTSP(0,1));
    }

    /**
     * 외판원 문제는 DP + 비트 마스킹을 활용하여 해결가능하다.
     */

    private static int calcTSP(int temp, int check) {
        // 모든 도시 방문 완료
        if(check == FullBit) {
            if(map[temp][0] == Integer.MAX_VALUE) {
                return INF;
            }
            return map[temp][0];
        }

        // 메모제이션
        if(dp[temp][check] != INF) {
            return dp[temp][check];
        }

        for(int i=0; i<N; i++) {
            // next를 기준으로 bit mask를 하여, 모든 경우의 수를 다 찾을 수 있다.
            int next = check | (1<<i);

            // 경로가 없거나 i 도시를 이미 방문했을 경우 continue
            if(map[temp][i] == Integer.MAX_VALUE || (check & (1<<i)) != 0) continue;

            dp[temp][check] = Math.min(dp[temp][check], calcTSP(i, next) + map[temp][i]);

        }

        return dp[temp][check];
    }

    private static void getMap(BufferedReader br) throws IOException {
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int distance = Integer.parseInt(st.nextToken());
                map[i][j] = distance == 0 ? Integer.MAX_VALUE : distance;
            }
        }
    }
}
