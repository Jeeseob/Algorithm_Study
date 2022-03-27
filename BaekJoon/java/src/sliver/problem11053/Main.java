package sliver.problem11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 의도
    public static void main(String[] args) throws IOException {
        int[] numbers = readConsoleData();
        int[] answers = findLIS(numbers);

        int answer = Arrays.stream(answers).max().orElse(-1);
        System.out.println(answer);
    }

    // 구현

    /**
     * 문제를 푸는데 필요한 데이터를 콘솔에서 읽어온다.
     * @return
     * @throws IOException
     */
    private static int[] readConsoleData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        return numbers;
    }

    /**
     * LIS를 찾는다. (DP 알고리즘 활용)
     * @param numbers
     * @return
     */
    private static int[] findLIS(int[] numbers) {
        int[] dynamicArray = new int[numbers.length];
        Arrays.fill(dynamicArray, 1);

        for (int i = 1; i < numbers.length; i++) {
            for (int j = 0; j < i; j++) {
                if(numbers[j] < numbers[i]) {
                    dynamicArray[i] = Math.max(dynamicArray[i], dynamicArray[j] + 1);
                }
            }
        }
        return dynamicArray;
    }
}
