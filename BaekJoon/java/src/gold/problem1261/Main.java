package gold.problem1261;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
    int xPos;
    int yPos;
    int brokenCount;

    public Point(int xPos, int yPos, int brokenCount) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.brokenCount = brokenCount;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public int getBrokenCount() {
        return brokenCount;
    }

    @Override
    public int compareTo(Point o) {
        return this.getBrokenCount() - o.getBrokenCount();
    }
}

public class Main {

    private static final int[] xPlus = new int[]{0, 0, 1, -1};
    private static final int[] yPlus = new int[]{1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[M][N];
        for (int i = 0; i < M; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(row.charAt(j)));
            }
        }

        boolean[][] visited = new boolean[M][N];
        for (boolean[] temp : visited) {
            Arrays.fill(temp, false);
        }

        PriorityQueue<Point> pointPriorityQueue = new PriorityQueue<>();
        pointPriorityQueue.add(new Point(0, 0, 0));

        int answer = 0;
        while (!pointPriorityQueue.isEmpty()) {
            Point tempPoint = pointPriorityQueue.poll();
            int tempXPos = tempPoint.getxPos();
            int tempYPos = tempPoint.getyPos();

            if(tempXPos == N-1 && tempYPos == M-1) {
                answer = tempPoint.getBrokenCount();
                break;
            }

            if(visited[tempYPos][tempXPos]) continue;

            visited[tempYPos][tempXPos] = true;

            for (int i = 0; i < 4; i++) {
                int nextXPos = tempXPos + xPlus[i];
                int nextYPos = tempYPos + yPlus[i];

                if (0 <= nextXPos && nextXPos < N && 0 <= nextYPos && nextYPos < M) {
                    if (board[nextYPos][nextXPos] == 1) {
                        pointPriorityQueue.add(new Point(nextXPos, nextYPos, tempPoint.getBrokenCount() + 1));
                    }
                    else {
                        pointPriorityQueue.add(new Point(nextXPos, nextYPos, tempPoint.getBrokenCount()));
                    }
                }
            }
        }

        System.out.println(answer);

    }
}
