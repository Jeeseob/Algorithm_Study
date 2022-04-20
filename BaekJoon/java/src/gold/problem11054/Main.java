package gold.problem11054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        initNumbers(bufferedReader);
        makeNumbers(bufferedReader);
        System.out.println(calc());
    }

    private static int calc() {
        int[] increases = calcIncrease();
        int[] decreases = calcDecrease();

        int answer = getAnswer(increases, decreases);
        return answer - 1;
    }

    private static int getAnswer(int[] increases, int[] decreases) {
        int answer = 0;
        for (int i = 0; i < numbers.length; i++) {
            answer = Math.max(answer, increases[i] + decreases[i]);
        }

        return answer;
    }

    private static int[] calcIncrease() {
        int[] increases = new int[numbers.length];
        increases[0] = 1;
        for (int i = 1; i < numbers.length; i++) {
            int temp = 0;
            for (int j = i; j >= 0; j--) {
                if(numbers[j] < numbers[i]) {
                    temp = Math.max(temp, increases[j]);
                }
            }
            increases[i] = temp + 1;
        }

        return increases;
    }

    private static int[] calcDecrease() {
        int[] decreases = new int[numbers.length];
        decreases[numbers.length-1] = 1;
        for (int i = numbers.length-2; i >= 0; i--) {
            int temp = 0;
            for (int j = i; j < numbers.length; j++) {
                if(numbers[j] < numbers[i]) {
                    temp = Math.max(temp, decreases[j]);
                }
            }
            decreases[i] = temp + 1;
        }

        return decreases;
    }


    private static void makeNumbers(BufferedReader bufferedReader) throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    private static void initNumbers(BufferedReader bufferedReader) throws IOException {
        int numberOfNumbers = Integer.parseInt(bufferedReader.readLine());
        numbers = new int[numberOfNumbers];
    }
}
