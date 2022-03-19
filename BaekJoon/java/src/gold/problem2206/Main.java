package gold.problem2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static char[][][] mapCahr;
    private static int[][] map;
    private static int column;
    private static int row;
    private static int[] addColumn = new int[]{0, 0, 1, -1};
    private static int[] addRow = new int[]{1, -1, 0, 0};

    private static Queue<int[]> pointQueue;
    private static Boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        column = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        if (column - 1 == 0 && row - 1 == 0) {
            System.out.print(1);
            return;
        }

        mapCahr = new char[2][column][row];
        visited = new Boolean[2][column][row];

        for (int i = 0; i < 2; i++) {
            for (Boolean[] check : visited[i]) {
                Arrays.fill(check, false);
            }
        }

        for(int i = 0; i < column; i++) {
            st = new StringTokenizer(br.readLine());
            String tempToken = st.nextToken();
            for(int j = 0; j < row; j++) {
                mapCahr[0][i][j] = mapCahr[1][i][j] = tempToken.charAt(j);
            }
        }

        map = new int[column][row];

        map[0][0] = 1;
        visited[0][0][0] = true;
        pointQueue = new LinkedList<>();

        pointQueue.add(new int[]{0,0,0});

        searchMap();


        if(map[column-1][row-1] == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(map[column-1][row-1]);
        return;
    }

    private static void searchMap() {
        int tempColumn;
        int tempRow;
        int tempWall;
        while(!pointQueue.isEmpty()) {
            int[] tempPoint = pointQueue.poll();
            tempColumn = tempPoint[0];
            tempRow = tempPoint[1];
            tempWall = tempPoint[2];

            // 4가지 방향중, 불가능한 방향, 이전 방향,
            for (int i = 0; i < 4; i++) {
                // 이전 방향으로 돌아가지 않는다.

                int nextColumn = tempColumn + addColumn[i];
                int nextRow = tempRow + addRow[i];

                if (0 <= nextColumn && nextColumn < column && 0 <= nextRow && nextRow < row) {
                    char nextData = mapCahr[tempWall][nextColumn][nextRow];
                    // 벽이 있는 경우
                    if (nextData == '1') {
                        // 벽이 있는데, 벽을 깬적이 없는 경우 벽을 깬다.
                        if (tempWall == 0 && !visited[1][nextColumn][nextRow]) {
                            map[nextColumn][nextRow] = map[tempColumn][tempRow] + 1;
                            visited[tempWall][nextColumn][nextRow] = true;
                            pointQueue.add(new int[]{nextColumn, nextRow, 1});
                        }
                    }

                    // 벽이 없는 경우
                    else {
                        if (!visited[tempWall][nextColumn][nextRow]) {
                            map[nextColumn][nextRow] = map[tempColumn][tempRow] + 1;
                            visited[tempWall][nextColumn][nextRow] = true;
                            pointQueue.add(new int[]{nextColumn, nextRow, tempWall});
                        }
                    }
                }
            }
        }
    }
}
//6 4
//0100
//1110
//1000
//0000
//0101
//0000