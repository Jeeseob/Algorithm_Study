package gold.problem2447;

import java.io.*;
import java.util.Arrays;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/08/17
 * @Problem : https://www.acmicpc.net/problem/2447
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        char[][] board;

        board = new char[N][N];
        for (char[] string : board) {
            Arrays.fill(string, ' ');
        }
        star(board, 0, 0, N);

        for (char[] string : board) {
            for (char data : string) {
                stringBuilder.append(data);
            }
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);
    }

    public static void star(char[][] arr, int xPos, int yPos, int N) {
        if (N == 1) {
            arr[xPos][yPos] = '*';
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1)) {
                    star(arr, xPos + i * (N / 3), yPos + j * (N / 3), N / 3);
                }
            }
        }
    }
}