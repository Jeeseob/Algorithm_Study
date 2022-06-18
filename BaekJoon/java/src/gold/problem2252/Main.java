package gold.problem2252;

import java.io.*;
import java.util.*;


class Fish implements Comparable<Fish> {
    private int xPos;
    private int yPos;

    private int sec; //상어가 이동해야하는 시간

    public Fish(int xPos, int yPos, int sec) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.sec = sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public int getSec() {
        return sec;
    }

    @Override // 우선순위, 거리(시간) > 높이(y축) > 왼쪽(x축)
    public int compareTo(Fish o) {
        if(this.getSec() == o.getSec()) {
            if(this.getyPos() == o.getyPos()) {
                return this.getxPos() - o.getxPos();
            }
            return this.getyPos() - o.getyPos();
        }
        return this.getSec() - o.getSec();
    }
}

public class Main {
    private static int sharkSize;
    private static int eatCount;
    private static int lastEatSec;
    static int[] xPlus = {0, -1, 0, 1};
    static int[] yPlus = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int sharkX = 0;
        int sharkY = 0;

        int N = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 9) {
                    sharkY = i;
                    sharkX = j;
                    board[i][j] = 0;
                }
                else {
                    board[i][j] = temp;
                }
            }
        }

        lastEatSec = 0;
        sharkSize = 2;

        PriorityQueue<Fish> fishQueue = new PriorityQueue<>();
        Queue<Fish> wayQueue = new LinkedList<>();
        wayQueue.add(new Fish(sharkX, sharkY, 0));

        boolean[][] visited = new boolean[N][N];
        for (boolean[] visit : visited) {
            Arrays.fill(visit, false);
        }

        while (true) {
            int maxSec = Integer.MAX_VALUE;
            while(!wayQueue.isEmpty()) {
                Fish tempShark = wayQueue.poll();
                if (tempShark.getSec() > maxSec) continue;

                int xPos = tempShark.getxPos();
                int yPos = tempShark.getyPos();

                if (visited[yPos][xPos]) continue;
                visited[yPos][xPos] = true;

                for (int i = 0; i < 4; i++) {
                    int nextXPos = xPos + xPlus[i];
                    int nextYPos = yPos + yPlus[i];

                    Fish nextShark = new Fish(nextXPos, nextYPos, tempShark.getSec() + 1);

                    if (nextXPos >= 0 && nextYPos >= 0 && nextXPos < N && nextYPos < N) {
                        if (board[nextYPos][nextXPos] > 0 && board[nextYPos][nextXPos] < sharkSize) {
                            fishQueue.add(nextShark);
                            maxSec = nextShark.getSec();

                        } else if (board[nextYPos][nextXPos] == sharkSize || board[nextYPos][nextXPos] == 0) {
                            wayQueue.add(nextShark);
                        }
                    }
                }
            }
            if (!fishQueue.isEmpty()) {
                Fish tempFish = fishQueue.poll();
                board[tempFish.getyPos()][tempFish.getxPos()] = 0;
                lastEatSec += tempFish.getSec();

                eatCount += 1;

                if (eatCount >= sharkSize) {
                    sharkSize += 1;
                    eatCount = 0;
                }

                // 초기화
                wayQueue.clear();
                fishQueue.clear();
                for (boolean[] visit : visited) {
                    Arrays.fill(visit, false);
                }

                // 새로운 위치 추가
                tempFish.setSec(0);
                wayQueue.add(tempFish);

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        System.out.print(" " + board[i][j]);
                    }
                    System.out.println();
                }
                System.out.println(lastEatSec);
            }

            else {
                break;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }
        System.out.println(lastEatSec);
    }
}
