package gold.problem11444;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 피보나치수열의 특정 값은 행렬의 제곱으로 구할 수 있다!!
// - 이것만 알면, 행렬의 제곱 문제랑 크게 다르지 않음
public class Main {
    private static final long MOD_NUMBER = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.valueOf(bufferedReader.readLine());
        long[][] finalibonacciMatrix = new long[][]{{1, 1}, {1, 0}};
        long[][] answer = divisionMatrix(finalibonacciMatrix, N);

        System.out.println(answer[1][0]);
        return;
    }

    // 거듭제곱을 분해하여, 행열을 계산하는 메소드 (지수를 2진법으로 보고, 분할하여 구하는 형태)
    private static long[][] divisionMatrix(long[][] matrix, long exponent) {
        if (exponent == 1L) {
            return matrix;
        }
        long[][] answerMatrix = divisionMatrix(matrix, exponent / 2);
        answerMatrix = multiplyMatrix(answerMatrix, answerMatrix);

        if (exponent % 2 == 1L) {
            answerMatrix = multiplyMatrix(answerMatrix, matrix);
        }
        return answerMatrix;
    }


    // 행열을 입력받아 곱해주는 메소드
    private static long[][] multiplyMatrix(long[][] matrix1, long[][] matrix2) {
        long[][] answerMatrix = new long[matrix1.length][matrix2[0].length];

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
}