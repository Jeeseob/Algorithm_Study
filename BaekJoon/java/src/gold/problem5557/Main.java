package gold.problem5557;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/08/29
 * @Problem : https://www.acmicpc.net/problem/5557
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        long[] answerNumbers = new long[21];
        answerNumbers[numbers[0]] = 1;
        for (int i = 1; i < N - 1; i++) {
            long[] tempNumbers = answerNumbers.clone();
            answerNumbers = new long[21];
            for (int j = 0; j < tempNumbers.length; j++) {
                int temp = j + numbers[i];
                if(temp <= 20 && 0 <= temp) {
                    answerNumbers[temp] += tempNumbers[j];
                }
                temp = j - numbers[i];
                if(temp <= 20 && 0 <= temp) {
                    answerNumbers[temp] += tempNumbers[j];
                }
            }
        }
        System.out.println(answerNumbers[numbers[N - 1]]);
    }
}
