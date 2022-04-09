package sliver.problem15654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int M;
    private static int[] data;
    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        readConsole();
        if (checkData()) {
            return;
        }

        int[] answer = new int[M];
        Arrays.fill(answer, -1);
        calc(stringBuilder, answer, 0);
        System.out.println(stringBuilder);
        return;
    }

    private static Boolean checkData() {
        if(M == 1) {
            for(int temp : data) {
                System.out.println(temp);
            }
            return true;
        }
        return false;
    }

    private static void calc(StringBuilder stringBuilder, int[] answer, int tempIndex) {
        if(tempIndex == M) {
            for(int tempData : answer) {
                stringBuilder.append(tempData + " ");
            }
            stringBuilder.append("\n");
            return;
        }

        for (int i = 0; i < data.length; i++) {
            if(checkArray(answer, data[i])) continue;
            answer[tempIndex] = data[i];
            calc(stringBuilder, answer, tempIndex + 1);
            answer[tempIndex] = -1;
        }
        return;
    }

    private static Boolean checkArray(int[] answer, int temp) {
        for (int i = 0; i < answer.length; i++) {
            if(answer[i] == temp) return true;
        }
        return false;
    }

    private static void readConsole() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        data = new int[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(data);
    }
}
