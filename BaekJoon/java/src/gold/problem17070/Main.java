package gold.problem17070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[][] board;
    private static int answer;
    
    public static void main(String[] args) throws IOException {
        readConsole();
        clacDFS(0,1,0);
        System.out.println(answer);
    }

    private static void clacDFS(int column, int row, int type) {
        if (column == N-1 && row == N-1) {
            answer++;
            return;
        }
        
        if(type == 0) {
            calcVertical(column, row);
        }
        
        if(type == 1) {
            calcHorizontal(column, row);
        }
            
        if(type == 2) {
            calcVertical(column, row);
            calcHorizontal(column, row);
        }

        calcDiagonal(column, row);
    }

    private static void calcDiagonal(int column, int row) {
        if (row + 1 < N && column + 1 < N && board[column][row + 1] == 0 && board[column + 1][row] == 0 && board[column + 1][row + 1] == 0) {
            clacDFS(column + 1, row + 1, 2);
        }
    }

    private static void calcHorizontal(int column, int row) {
        if (column + 1 < N && board[column + 1][row] == 0) {
            clacDFS(column + 1, row, 1);
        }
    }

    private static void calcVertical(int column, int row) {
        if (row + 1 < N && board[column][row + 1] == 0) {
            clacDFS(column, row + 1, 0);
        }
    }

    private static void readConsole() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        makeBoard(bufferedReader);
    }

    private static void makeBoard(BufferedReader bufferedReader) throws IOException {
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
    }
}
