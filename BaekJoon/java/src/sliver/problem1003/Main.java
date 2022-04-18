package sliver.problem1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int temp = Integer.parseInt(br.readLine());
            if(temp == 0) {
                System.out.println("1 0");
                continue;
            }
            else if(temp == 1) {
                System.out.println("0 1");
                continue;
            }

            numbers = new int[temp+1];
            numbers[temp] = 1;
            calcFibonacci(temp);
            System.out.println(numbers[0] + " " + numbers[1]);
        }
        return;
    }

    private static void calcFibonacci(int temp) {
        for(int i = temp; i > 1; i--) {
            numbers[i - 1] += numbers[i];
            numbers[i - 2] += numbers[i];
        }
        return;
    }
}
