package gold.poblem2239;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    private static final int LENGTH = 9;
    private static int[][] board;
    private static ArrayList<Point> blanks;

    public static void main(String[] args) throws IOException {
        board = new int[LENGTH][LENGTH];
        blanks = new ArrayList<>();

        getBoard();
        calc(0);
    }

    private static void getBoard() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < LENGTH; i++) {
            String line = br.readLine();
            for (int j = 0; j < LENGTH; j++) {
                int temp = line.charAt(j) - '0';
                if(temp == 0) {
                    blanks.add(new Point(i, j));
                }
                board[i][j] = temp;
            }
        }
    }

    private static void print() {
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private static void calc(int tempBlank) {
        if (tempBlank == blanks.size()) {
            print();
            System.exit(0);
        }

        boolean[] line = new boolean[LENGTH+1];

        Point temp = blanks.get(tempBlank);
        int tempXPos = temp.getxPos();
        int tempYPos = temp.getyPos();

        for (int i = 0; i < LENGTH; i++) {
            line[board[tempXPos][i]] = true;
            line[board[i][tempYPos]] = true;
        }

        int xPos = (tempXPos / 3) * 3;
        int yPos = (tempYPos / 3) * 3;
        for (int i = 0; i < LENGTH / 3; i++) {
            for (int j = 0; j < LENGTH / 3; j++) {
                line[board[xPos+ i][yPos+ j]] = true;
            }
        }

        for (int i = 1; i <= LENGTH; i++) {
            if(line[i]) continue;
            board[tempXPos][tempYPos] = i;
            calc(tempBlank+1);
        }
        board[tempXPos][tempYPos] = 0;
    }

    private static class Point {
        private int xPos;
        private int yPos;

        public int getxPos() {
            return xPos;
        }

        public int getyPos() {
            return yPos;
        }

        public Point(int xPos, int yPos) {
            this.xPos = xPos;
            this.yPos = yPos;
        }
    }
}
