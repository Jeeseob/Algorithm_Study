package gold.problem1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int lengthOfNumbers = Integer.parseInt(st.nextToken());
        int targetNumber = Integer.parseInt(st.nextToken());

        int[] numbers = new int[lengthOfNumbers+1];
        getNumbers(br, numbers);
        System.out.println(twoPointer(targetNumber, numbers));
    }

    private static int twoPointer(int targetNumber, int[] numbers) {
        int tempSum = 0;
        int answer = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        while(start < numbers.length && end < numbers.length) {
            if(tempSum >= targetNumber) {
                if(answer > end - start) {
                    answer = end - start;
                }
                tempSum -= numbers[start];
                start++;
            }

            else {
                tempSum += numbers[end];
                end++;
            }
        }

        if(answer == Integer.MAX_VALUE) {
            return 0;
        }

        return answer;
    }


    private static int[] getNumbers(BufferedReader br, int[] numbers) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < numbers.length-1; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        return numbers;
    }
}
