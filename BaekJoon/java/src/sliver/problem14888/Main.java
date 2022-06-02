package sliver.problem14888;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int max = Integer.MIN_VALUE;    // 최댓값
    public static int min = Integer.MAX_VALUE;    // 최솟값
    public static int[] operators = new int[4];    // 연산자 개수
    public static int[] numbers;                    // 숫자
    public static int N;                        // 숫자 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        getN(br);
        getNumbers(br);
        getOperations(br);

        dfs(numbers[0], 1);
        System.out.println(max);
        System.out.println(min);

    }

    public static void dfs(int num, int index) {
        if (index == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                switch (i) {
                    case 0:
                        dfs(num + numbers[index], index + 1);
                        break;
                    case 1:
                        dfs(num - numbers[index], index + 1);
                        break;
                    case 2:
                        dfs(num * numbers[index], index + 1);
                        break;
                    case 3:
                        dfs(num / numbers[index], index + 1);
                        break;
                }
                operators[i]++;
            }
        }
    }

    private static void getN(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
    }

    private static void getOperations(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void getNumbers(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    }
}
