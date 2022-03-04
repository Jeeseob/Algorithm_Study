package gold.problem7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 백준 토마토 문제(7576)

class Position {
    private int xPos;
    private int yPos;
    private int count;

    public Position(int xPos, int yPos, int count) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.count = count; // 현재 좌표까지 도달하는데 걸린 일 수
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public int getCount() {
        return count;
    }
}

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Queue<Position> positionQueue = new LinkedList<>();

        int X = scanner.nextInt();
        int Y = scanner.nextInt();

        int[][] board = new int[Y][X];

        // 데이터를 보드에 입력
        for(int y = 0; y < Y; y++) {
            for( int x = 0; x < X; x++) {
                board[y][x] = scanner.nextInt();
                if(board[y][x] == 1) {
                    positionQueue.add(new Position(x, y, 0));
                }
            }
        }


        int answer = 0;
        while (!positionQueue.isEmpty()) {
            Position tempPosition = positionQueue.poll();

            // 현재 좌표에 도달하는 최소시간 + 1이 다음 좌표에 도달하는 시간이다.
            answer = tempPosition.getCount()+1;
            if(tempPosition.getXPos() > 0) {
                calcBoard(tempPosition.getXPos() - 1, tempPosition.getYPos(), board, positionQueue, answer);
            }
            if(tempPosition.getXPos() < X-1) {
                calcBoard(tempPosition.getXPos() + 1, tempPosition.getYPos(), board, positionQueue, answer);
            }
            if(tempPosition.getYPos() > 0) {
                calcBoard(tempPosition.getXPos(), tempPosition.getYPos() - 1, board, positionQueue, answer);
            }
            if(tempPosition.getYPos() < Y-1) {
                calcBoard(tempPosition.getXPos(), tempPosition.getYPos() + 1, board, positionQueue, answer);
            }
        }

        // -1로 둘러쌓인 경우
        for(int y = 0; y < Y; y++) {
            for( int x = 0; x < X; x++) {
                if(board[y][x] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(answer-1);
        return;
    }

    private static void calcBoard(int x, int y, int[][] board, Queue<Position> positionQueue, int answer) {
        if(board[y][x] == 0) {
            positionQueue.add(new Position(x,y,answer));
            board[y][x] = 1;
        }
    }
}
