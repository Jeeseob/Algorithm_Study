package gold.problem1107;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final int MAX = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int numberOfBrokenButton = Integer.parseInt(br.readLine());

        boolean[] brokenButtons = initButtons();

        if (numberOfBrokenButton > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < numberOfBrokenButton; i++) {
                int tempButton = Integer.parseInt(st.nextToken());
                brokenButtons[tempButton] = true;
            }
        }

        // +/-로만 이동했을 때
        int answer = Math.abs(N - 100);

        // 모든 경우의 수를 시도해야 한다. / brute force
        for (int temp = 0; temp < MAX; temp++) {
            int tempData = calcData(temp, brokenButtons);
            if (tempData > 0) {
                int press = Math.abs(temp - N);
                int tempAnswer = tempData + press;
                answer = Math.min(answer, tempAnswer);
            }
        }
        System.out.println(answer);
    }

    static int calcData(int temp, boolean[] brokenButtons) {
        if (temp == 0) {
            if (brokenButtons[0]) {
                return 0;
            }
            return 1;
        }

        int length = 0;
        while (temp > 0) {
            if (brokenButtons[temp % 10]) {
                return 0;
            }
            length++;
            temp /= 10;
        }
        return length;
    }

    private static boolean[] initButtons() {
        boolean[] brokenButtons = new boolean[10];
        Arrays.fill(brokenButtons, false);
        return brokenButtons;
    }
}
