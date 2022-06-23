package gold.problem3055;

import java.io.*;
import java.util.*;


class Location extends Point implements Comparable<Location> {
    private int count;
    public Location(int xPos, int yPos, int count) {
        super(xPos, yPos);
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    @Override
    public int compareTo(Location o) {
        return Integer.compare(this.count, o.getCount());
    }
}

class Point {
    private int xPos;
    private int yPos;

    public Point(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }
}

public class Main {
    private static int[] xPlus = new int[]{-1, 1, 0, 0};
    private static int[] yPlus = new int[]{0, 0, 1, -1};
    private static List<Point> waterList;

    private static int X;
    private static int Y;

    private static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        board = new char[Y][X];
        boolean[][] visited = new boolean[Y][X];
        for (boolean[] temp : visited) {
            Arrays.fill(temp, false);
        }


        Point start = null;

        waterList = new ArrayList<>();

        for (int i = 0; i < Y; i++) {
            String row = br.readLine();
            for (int j = 0; j < X; j++) {
                char temp =  row.charAt(j);
                if(temp == '*') {
                    waterList.add(new Point(j, i));
                }
                else if (temp == 'S') {
                    start = new Point(j, i);
                }
                board[i][j] = temp;
            }
        }


        PriorityQueue<Location> movePoint = new PriorityQueue<>();
        movePoint.add(new Location(start.getxPos(), start.getyPos(), 0));

        int count = 0;

        while (!movePoint.isEmpty()) {
            Location tempLocation = movePoint.poll();
            int tempXPos = tempLocation.getxPos();
            int tempYPos = tempLocation.getyPos();
            int tempCount = tempLocation.getCount();

            if(visited[tempYPos][tempXPos]) continue;
            visited[tempYPos][tempXPos] = true;

            // 물 이동
            if (tempCount > count) {
                moveWater();
                count++;
                // 현재 위치에 물이 닿은 경우 도달하지 못하는 것으로 간주
                if (board[tempYPos][tempXPos] == '*') continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextXPos = tempXPos + xPlus[i];
                int nextYPos = tempYPos + yPlus[i];
                if (0 <= nextXPos && nextXPos < X && 0 <= nextYPos && nextYPos < Y) {
                    if(board[nextYPos][nextXPos] == '.') {
                        movePoint.add(new Location(nextXPos, nextYPos, tempCount + 1));
                    } else if (board[nextYPos][nextXPos] == 'D') {
                        System.out.println(tempCount+1);
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println("KAKTUS");
    }

    private static void moveWater() {
        List<Point> newWaterList = new ArrayList<>();
        for (Point tempWater : waterList) {
            for (int i = 0; i < 4; i++) {
                int nextXPos = tempWater.getxPos() + xPlus[i];
                int nextYPos = tempWater.getyPos() + yPlus[i];
                if (0 <= nextXPos && nextXPos < X && 0 <= nextYPos && nextYPos < Y) {
                    if(board[nextYPos][nextXPos] == '.' || board[nextYPos][nextXPos] == 'S') {
                        board[nextYPos][nextXPos] = '*';
                        newWaterList.add(new Point(nextXPos, nextYPos));
                    }
                }
            }
        }
        waterList = newWaterList;
    }
}

