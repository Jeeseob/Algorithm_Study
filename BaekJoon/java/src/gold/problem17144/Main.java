package gold.problem17144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] board;

    private static int row;
    private static int column;
    private static int second;

    private static int airCleanerColumn;
    public static void main(String[] args) throws IOException {

        readConsole();

        for(int repeat = 0; repeat < second; repeat++) {
            int[][] newBoard = makeNewBoard();
            clacDustBoard(newBoard);
            boardCopy(newBoard);
            cleanAir();
        }

        print();

    }

    private static int[][] makeNewBoard() {
        int[][] newBoard = new int[column][row];
        // 공기청정기 위치 복사
        newBoard[airCleanerColumn][0] = -1;
        newBoard[airCleanerColumn - 1][0] = -1;
        return newBoard;
    }

    private static void boardCopy(int[][] newBoard) {
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                board[i][j] = newBoard[i][j];
            }
        }
    }

    private static void cleanAir() {
        // 공기청정
        int tempRow = 1;
        int tempColumn = airCleanerColumn - 1;
        int tempData1;
        int tempData2 = board[tempColumn][tempRow];

        while (tempRow < row - 1) {
            tempData1 = board[tempColumn][tempRow + 1];
            board[tempColumn][tempRow + 1] = tempData2;
            tempData2 = tempData1;
            tempRow++;
        }

        while (tempColumn > 0) {
            tempData1 = board[tempColumn - 1][tempRow];
            board[tempColumn - 1][tempRow] = tempData2;
            tempData2 = tempData1;
            tempColumn--;
        }

        while (tempRow > 0) {
            tempData1 = board[tempColumn][tempRow - 1];
            board[tempColumn][tempRow - 1] = tempData2;
            tempData2 = tempData1;
            tempRow--;
        }

        while (tempColumn < airCleanerColumn - 2) {
            tempData1 = board[tempColumn + 1][tempRow];
            board[tempColumn + 1][tempRow] = tempData2;
            tempData2 = tempData1;
            tempColumn++;
        }


        // 공기청정
        tempRow = 1;
        tempColumn = airCleanerColumn;
        tempData2 = board[tempColumn][tempRow];

        while (tempRow < row - 1) {
            tempData1 = board[tempColumn][tempRow + 1];
            board[tempColumn][tempRow + 1] = tempData2;
            tempData2 = tempData1;
            tempRow++;
        }

        while (tempColumn < column - 1) {
            tempData1 = board[tempColumn + 1][tempRow];
            board[tempColumn + 1][tempRow] = tempData2;
            tempData2 = tempData1;
            tempColumn++;
        }


        while (tempRow > 0) {
            tempData1 = board[tempColumn][tempRow - 1];
            board[tempColumn][tempRow - 1] = tempData2;
            tempData2 = tempData1;
            tempRow--;
        }

        while (tempColumn > airCleanerColumn + 1) {
            tempData1 = board[tempColumn - 1][tempRow];
            board[tempColumn - 1][tempRow] = tempData2;
            tempData2 = tempData1;
            tempColumn--;
        }

        board[airCleanerColumn][1] = 0;
        board[airCleanerColumn-1][1] = 0;
    }

    private static void print() {
        int answer = 0;
        for(int[] tempArray : board) {
            for(int temp : tempArray) {
                if(temp != -1) {
                    answer += temp;
                }
            }
        }
        System.out.println(answer);
    }

    private static void clacDustBoard(int[][] newBoard) {
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                // 상하좌우
                if(j == 0 && (i == airCleanerColumn || i == airCleanerColumn - 1)) continue;

                int dust = board[i][j] / 5;
                newBoard[i][j] += board[i][j];
                if (0 < i && board[i - 1][j] != -1) {
                    calcDust(newBoard, i, j, dust, i - 1, j);
                }

                if (i < column - 1 && board[i + 1][j] != -1) {
                    calcDust(newBoard, i, j, dust, i + 1, j);
                }

                if (j > 0 && board[i][j - 1] != -1) {
                    calcDust(newBoard, i, j, dust, i, j - 1);
                }

                if (j < row - 1 && board[i][j + 1] != -1) {
                    calcDust(newBoard, i, j, dust, i, j + 1);
                }
            }
        }
    }

    private static void calcDust(int[][] newBoard, int i, int j, int dust, int i2, int j2) {
        newBoard[i][j] -= dust;
        newBoard[i2][j2] += dust;
    }


    private static void readConsole() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        column = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        second = Integer.parseInt(st.nextToken());

        makeBoard(br, row, column);
    }

    private static void makeBoard(BufferedReader br, int row, int column) throws IOException {
        board = new int[column][row];

        for(int tempColumn = 0; tempColumn < column; tempColumn++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int tempRow = 0; tempRow < row; tempRow++) {
                int tempData = Integer.parseInt(st.nextToken());
                if(tempData == -1) {
                    airCleanerColumn = tempColumn;
                }
                board[tempColumn][tempRow] = tempData;
            }
        }
    }

}
