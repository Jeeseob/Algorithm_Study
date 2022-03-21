package gold.problem2638;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][] cheeseMap;
    private static int[] addColumn = new int[]{0, 0, 1, -1};
    private static int[] addRow = new int[] {1, -1, 0, 0};

    private static int maxColumn;
    private static int maxRow;
    private static  ArrayList<int[]> cheesePoints;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        maxColumn = Integer.parseInt(st.nextToken());
        maxRow = Integer.parseInt(st.nextToken());
        cheesePoints = new ArrayList<>();

        cheeseMap = new int[maxColumn][maxRow];

        for (int i = 0; i < maxColumn; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < maxRow; j++) {
                cheeseMap[i][j] = Integer.parseInt(st.nextToken());
                if(cheeseMap[i][j] == 1) {
                    cheesePoints.add(new int[]{i, j});
                }
            }
        }

        if(cheesePoints.size() == 0) {
            System.out.println(0);
            return;
        }

        // 외부 공기와 내부 공기를 구분해야한다.

        // 0,0과 연결된 곳들은 외부공기이다.
        // 0,0과 연결되지 않은 곳들은 내부공기이다.

        findOutAir(0, 0);

        int count = 1;

        while(findMeltCheese() != 0){
            count++;
        }

        System.out.println(count);
    }

    // 외부 공기를 -1로 바꿔준다.
    private static void findOutAir(int startColumn, int startRow) {
        Queue<int[]> airQueue = new LinkedList<>();
        airQueue.add(new int[]{startColumn,startRow});

        while(!airQueue.isEmpty()) {
            int[] tempPoint = airQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nextColumn = tempPoint[0] + addColumn[i];
                int nextRow = tempPoint[1] + addRow[i];

                if (0 <= nextColumn && nextColumn < maxColumn && 0 <= nextRow && nextRow < maxRow) {
                    if(cheeseMap[nextColumn][nextRow] == 0) {
                        // 외부 공기를 -1로 변경
                        cheeseMap[nextColumn][nextRow] = -1;
                        airQueue.add(new int[]{nextColumn, nextRow});
                    }
                }
            }
        }
    }

    // 외부 공기와 2개 이상 연결된 치즈를 녹인다.
    private static int findMeltCheese() {
        Queue<int[]> meltQueue = new LinkedList<>();
        for(int i = 0; i < cheesePoints.size(); i++) {
            int[] cheesePoint = cheesePoints.get(i);
            int count = 0;

            for (int temp = 0; temp < 4; temp++) {
                int nextColumn = cheesePoint[0] + addColumn[temp];
                int nextRow = cheesePoint[1] + addRow[temp];

                if (0 <= nextColumn && nextColumn < maxColumn && 0 <= nextRow && nextRow < maxRow) {
                    if(cheeseMap[nextColumn][nextRow] == -1) {
                        if (++count >= 2) {
                            meltQueue.add(new int[]{cheesePoint[0], cheesePoint[1]});
                            cheesePoints.remove(cheesePoint);
                            i--;
                            break;
                        }
                    }
                }
            }
        }

        // 녹은 치즈 중, 내부 공기와 연결된 치즈가 있다면, 그 공기와 연결된 공기들을 외부 공기로 변환한다.
        while(!meltQueue.isEmpty()) {
            int[] meltPoint = meltQueue.poll();
            cheeseMap[meltPoint[0]][meltPoint[1]] = -1;
            findOutAir(meltPoint[0], meltPoint[1]);
        }

        return cheesePoints.size();
    }
}
