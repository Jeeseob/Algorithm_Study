package gold.problem2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[] addColumn = new int[]{0, 0, 1, -1};
    private static int[] addRow = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int column = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        if (column == 1 && row == 1) {
            System.out.println(1);
            return;
        }

        char[][][] mapChar = new char[2][column][row];
        Boolean[][][] visited = new Boolean[2][column][row];

        for (int i = 0; i < 2; i++) {
            for (Boolean[] check : visited[i]) {
                Arrays.fill(check, false);
            }
        }

        for (int i = 0; i < column; i++) {
            st = new StringTokenizer(br.readLine());
            String tempToken = st.nextToken();
            for (int j = 0; j < row; j++) {
                mapChar[0][i][j] = mapChar[1][i][j] = tempToken.charAt(j);
            }
        }

        br.close();

        int[][] map = new int[column][row];

        map[0][0] = 1;
        visited[0][0][0] = true;

        Queue<int[]> pointQueue = new LinkedList<>();
        pointQueue.add(new int[]{0, 0, 0});

        int tempColumn;
        int tempRow;
        int tempWall;
        int nextColumn;
        int nextRow;

        while (!pointQueue.isEmpty()) {
            int[] tempPoint = pointQueue.poll();

            tempWall = tempPoint[0];
            tempColumn = tempPoint[1];
            tempRow = tempPoint[2];

            if (tempColumn == column - 1 && tempRow == row - 1) {
                System.out.println(map[column - 1][row - 1]);
                return;
            }

            // 4가지 방향중, 불가능한 방향, 이전 방향,
            for (int i = 0; i < 4; i++) {
                // 이전 방향으로 돌아가지 않는다.
                nextColumn = tempColumn + addColumn[i];
                nextRow = tempRow + addRow[i];

                if (0 <= nextColumn && nextColumn < column && 0 <= nextRow && nextRow < row) {
                    char nextData = mapChar[tempWall][nextColumn][nextRow];

                    // 벽이 있는 경우
                    if (nextData == '1') {
                        // 벽을 깬적이 없는 경우 벽을 깬다.
                        if (tempWall == 0 && !visited[1][nextColumn][nextRow]) {
                            map[nextColumn][nextRow] = map[tempColumn][tempRow] + 1;
                            visited[1][nextColumn][nextRow] = true;
                            pointQueue.add(new int[]{1, nextColumn, nextRow});
                        }
                    }

                    // 벽이 없는 경우
                    else {
                        if (!visited[tempWall][nextColumn][nextRow]) {
                            map[nextColumn][nextRow] = map[tempColumn][tempRow] + 1;
                            visited[tempWall][nextColumn][nextRow] = true;
                            pointQueue.add(new int[]{tempWall, nextColumn, nextRow});
                        }
                    }
                }
            }
        }
        System.out.println(-1);
        return;
    }
}