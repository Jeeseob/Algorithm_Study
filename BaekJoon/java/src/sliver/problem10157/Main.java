package sliver.problem10157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/08/21
 * @Problem : https://www.acmicpc.net/problem/10157
 */

public class Main {
    private static int C;
    private static int R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int waitNumber = Integer.parseInt(br.readLine());

        if (waitNumber > C * R) {
            System.out.println(0);
            System.exit(0);
        }

        boolean[][] hall = new boolean[R][C];
        for (boolean[] line : hall) {
            Arrays.fill(line, false);
        }

        int count = 1;
        int r = 0;
        int c = 0;
        int direction = 0;
        hall[0][0] = true;

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        while (waitNumber > count) {
            int tempDircetion = direction % 4;
            int nr = r + dr[tempDircetion];
            int nc = c + dc[tempDircetion];
            if (inRange(nr, nc) && (!hall[nr][nc])) {
                r = nr;
                c = nc;
                hall[r][c] = true;
                count++;
                continue;
            }
            direction++;
        }

        System.out.println((c+1) + " " + (r+1));
    }

    public static boolean inRange(int r, int c) {
        return 0 <= r && r < R && 0<= c && c < C;
    }
}
