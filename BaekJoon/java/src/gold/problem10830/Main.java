package gold.problem10830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int MOD_NUMBER = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int matrixLength = Integer.parseInt(stringTokenizer.nextToken());
        long exponent = Long.valueOf(stringTokenizer.nextToken());
        int[][] matrix = makeMatrix(bufferedReader, matrixLength);

        matrix = divisionMatrix(matrix, exponent);
        print(matrix);
    }

    private static void print(int[][] matrix) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] tempRow : matrix) {
            for (int temp : tempRow) {
                stringBuilder.append(temp + " ");
            }
            stringBuilder.append('\n');
        }
        System.out.println(stringBuilder);
    }


    // 거듭제곱을 분해하여, 행열을 계산하는 메소드 (지수를 2진법으로 보고, 분할하여 구하는 형태)
    private static int[][] divisionMatrix(int[][] matrix, long exponent) {
        if(exponent == 1L) {
            return matrix;
        }
        int[][] answerMatrix = divisionMatrix(matrix, exponent/2);
        answerMatrix =  multiplyMatrix(answerMatrix, answerMatrix);

        if(exponent%2 == 1L) {
            answerMatrix = multiplyMatrix(answerMatrix, matrix);
        }
        return answerMatrix;
    }

    // 행열을 입력받아 곱해주는 메소드
    private static int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] answerMatrix = new int[matrix1.length][matrix2[0].length];

        for(int k = 0; k < matrix1.length; k++){
            for(int i = 0; i < matrix2[0].length; i++){
                for(int j = 0; j < matrix1[0].length; j++) {
                    answerMatrix[k][i] += matrix1[k][j] * matrix2[j][i];
                    answerMatrix[k][i] %= MOD_NUMBER;
                }
            }
        }

        return answerMatrix;
    }

    private static int[][] makeMatrix(BufferedReader bufferedReader, int matrixLength) throws IOException {
        StringTokenizer stringTokenizer;
        int[][] matrix = new int[matrixLength][matrixLength];
        for (int column = 0; column < matrixLength; column++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            for (int row = 0; row < matrixLength; row++) {
                // 값이 커지기 때문에 1000으로 나누는데 1000이하의 값을 주기 때문에 1000을 받으면 0으로 바꿔줘야 함.
                matrix[column][row] = Integer.parseInt(stringTokenizer.nextToken())%MOD_NUMBER;
            }
        }
        return matrix;
    }
}