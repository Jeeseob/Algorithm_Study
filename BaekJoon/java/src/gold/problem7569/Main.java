package gold.problem7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/08/19
 * @Problem : https://www.acmicpc.net/problem/7569
 */

public class Main {
    private static int[] zPlus = new int[]{ 0, 0, 0, 0, -1, 1 };
    private static int[] yPlus = new int[]{ 0, 0, -1, 1, 0, 0 };
    private static int[] xPlus = new int[]{ -1, 1, 0, 0, 0, 0 };

    private static Queue<Point> queue = new LinkedList<>();
    private static int unTomato;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] box = new int[H][N][M];

        unTomato = 0;
        for(int i = 0; i < H; i++){
            for(int j = 0; j < M; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < N; k++){
                    box[i][k][j] = Integer.parseInt(st.nextToken());
                    if(box[i][k][j] == 1)  {
                        queue.add(new Point(j, k, i));
                    } else if (box[i][k][j] == 0) {
                        unTomato++;
                    }
                }
            }
        }
        int result = 0;
        while (unTomato > 0 && !queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point tempTomato = queue.poll();
                int tempX = tempTomato.getxPos();
                int tempY = tempTomato.getyPos();
                int tempZ = tempTomato.getzPos();

                for (int j = 0; j < 6; j++) {
                    int nextX = tempX + xPlus[j];
                    int nextY = tempY + yPlus[j];
                    int nextZ = tempZ + zPlus[j];

                    if (0 <= nextX && nextX < M && 0 <= nextY && nextY < N && 0 <= nextZ && nextZ < H) {
                        if (box[nextZ][nextY][nextX] == 0) {
                            unTomato--;
                            box[nextZ][nextY][nextX] = 1;
                            queue.add(new Point(nextX, nextY, nextZ));
                        }
                    }
                }
            }
            result++;
        }
        System.out.println(unTomato == 0 ? result : -1);
    }

}

class Point {
    private int xPos;
    private int yPos;
    private int zPos;

    public Point(int xPos, int yPos, int zPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.zPos = zPos;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public int getzPos() {
        return zPos;
    }
}
