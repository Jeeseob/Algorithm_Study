package sliver.problem9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 의도와 구현을 구분하자.
public class Main {

    private static BufferedReader br;
    private static StringTokenizer st;
    private static int[] answers;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int repitition = readSingleNumber();
        answers = new int[repitition];
        for (int i = 0; i < repitition; i++) {
            int numberOfRow = readSingleNumber();
            int[][] tempArray = readStickerArray(numberOfRow);

            answers[i] = findMaxSticker(tempArray);
        }
        for(int i = 0; i < repitition; i++) {
            System.out.println(answers[i]);
        }
    }

    // 스티커 배열 입력받기
    private static int[][] readStickerArray(int numberOfRow) throws IOException {
        int[][] tempArray = new int[2][numberOfRow];

        for (int tempColumn = 0; tempColumn < 2; tempColumn++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int tempRow = 0; tempRow < numberOfRow; tempRow++) {
                tempArray[tempColumn][tempRow] = Integer.parseInt(st.nextToken());
            }
        }
        return tempArray;
    }

    // 숫자 하나 입력받기
    private static int readSingleNumber() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    // 실제 계산(DP사용)
    private static int findMaxSticker(int[][] stickerArray) {
        int maxRow = stickerArray[0].length;
        stickerArray[0][1] += stickerArray[1][0];
        stickerArray[1][1] += stickerArray[0][0];
        for (int row = 2; row < maxRow; row++) {
            stickerArray[0][row] += Math.max(stickerArray[0][row - 2], Math.max(stickerArray[1][row - 1], stickerArray[1][row - 2]));
            stickerArray[1][row] += Math.max(stickerArray[1][row - 2], Math.max(stickerArray[0][row - 1], stickerArray[0][row - 2]));
        }
        int col0 = Math.max(stickerArray[0][maxRow - 1], stickerArray[0][maxRow - 2]);
        int col1 = Math.max(stickerArray[1][maxRow - 1], stickerArray[1][maxRow - 2]);
        return Math.max(col0, col1);
    }
}

