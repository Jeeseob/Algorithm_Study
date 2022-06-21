package gold.problem1987;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    private static final int[] xPlus = {0, 0, -1, 1};
    private static final int[] yPlus = {1, -1, 0, 0};
    private static boolean[] beforeVisited;
    private static int[][] board;
    private static int max;
    private static int R, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = row.charAt(j) - 65;
            }
        }


        //init
        max = 0;
        beforeVisited = new boolean[26]; //알파벳
        Arrays.fill(beforeVisited, false);
        beforeVisited[board[0][0]] = true;

        //DFS
        dfs(0, 0, 1);

        System.out.println(max);
    }

    private static void dfs(int xPos, int yPos, int count) {
        max = Math.max(max, count);
        for (int i = 0; i < 4; i++) {
            int nextXPos = xPos + xPlus[i];
            int nextYPos = yPos + yPlus[i];
            if (0 <= nextXPos && nextXPos < C && 0 <= nextYPos && nextYPos < R) {
                if (!beforeVisited[board[nextYPos][nextXPos]]) { // 알파벳 체크
                    beforeVisited[board[nextYPos][nextXPos]] = true;
                    dfs(nextXPos, nextYPos, count+1);
                    //현재 알파멧 체크 풀기
                    beforeVisited[board[nextYPos][nextXPos]] = false;
                }
            }
        }
    }
}
