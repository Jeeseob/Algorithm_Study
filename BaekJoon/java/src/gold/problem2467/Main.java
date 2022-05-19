package gold.problem2467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] numbers = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Long.parseLong(st.nextToken());
        }

        int left = 0;
        int right = N-1;

        int answerLeft = 0;
        int answerRight = 0;

        long min = Integer.MAX_VALUE;
        while(left<right){
            long sum = numbers[left] + numbers[right];
            long absSum = Math.abs(sum);

            if (min > absSum) {
                min = absSum;
                answerLeft = left;
                answerRight = right;
            }

            if (sum > 0) {
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                break;
            }
        }
        System.out.println(numbers[answerLeft] + " " + numbers[answerRight]);
    }
}
