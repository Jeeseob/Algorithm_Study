package sliver.prolbem11660;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int boardLength;
    private static int numberOfAnswer;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        readConsole();
        int[][] board = readBoard();
        for (int i = 0; i < numberOfAnswer; i++) {
            int answer  = calcAnswer(board);
            print(bw, answer);
        }

        br.close();
        bw.flush();
        bw.close();
        return;
    }

    private static void print(BufferedWriter bw, int answer) throws IOException {
        bw.write(answer + "\n");
    }

    private static int calcAnswer(int[][] board) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] startPoint = new int[]{Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1};
        int[] endPoint = new int[]{Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1};
        int answer = 0;

        for (int tempX = startPoint[0]; tempX <= endPoint[0]; tempX++) {
            answer += board[tempX][endPoint[1]];
        }

        if(startPoint[1] != 0) {
            for (int tempX = startPoint[0]; tempX <= endPoint[0]; tempX++) {
                answer -= board[tempX][startPoint[1] - 1];
            }
        }

        return answer;
    }

    private static void readConsole() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        boardLength = Integer.parseInt(st.nextToken());
        numberOfAnswer = Integer.parseInt(st.nextToken());
    }

    private static int[][] readBoard() throws IOException {
        int[][] board = new int[boardLength][boardLength];
        for (int i = 0; i < boardLength; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int temp = 0;
            for (int j = 0; j < boardLength; j++) {
                temp += Integer.parseInt(st.nextToken());
                board[i][j] = temp;
            }
        }
        return board;
    }
}
