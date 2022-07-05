package alogrithmMonday.firstWeek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/07/06
 */

class Main {
    private static int[] xPlus = new int[]{0, 0, 1, 1, 1, -1, -1, -1};
    private static int[] yPlus = new int[]{1, -1, 0, 1, -1, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        int xPos = Integer.parseInt(stringTokenizer.nextToken());
        int yPos = Integer.parseInt(stringTokenizer.nextToken());

        char[][] originBoard = new char[yPos][xPos];
        int[][] board = new int[yPos][xPos];

        for (int i = 0; i < yPos; i++) {
            String tempRow = br.readLine();
            for (int j = 0; j < xPos; j++) {
                originBoard[i][j] = tempRow.charAt(j);
            }
        }

        for (int i = 0; i < yPos; i++) {
            for (int j = 0; j < xPos; j++) {
                if (originBoard[i][j] == '*') {
                    board[i][j] = 9;
                }
                else {
                    int tempData = 0;
                    for (int k = 0; k < 8; k++) {
                        int nextYPos = i + yPlus[k];
                        int nextXPos = j + xPlus[k];
                        if (0 <= nextXPos && nextXPos < xPos && 0 <= nextYPos && nextYPos < yPos) {
                            if (originBoard[nextYPos][nextXPos] == '*') {
                                tempData++;
                            }
                        }
                    }
                    board[i][j] = tempData;
                }
            }
        }

        for (int i = 0; i < yPos; i++) {
            for (int j = 0; j < xPos; j++) {
                if (board[i][j] == 9) {
                    System.out.print("*");
                } else {
                    System.out.print(board[i][j]);
                }
            }
            System.out.println();
        }
    }
}

