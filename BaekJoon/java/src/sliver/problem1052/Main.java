package sliver.problem1052;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static ArrayList<Integer> checkList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N <= K) {
            System.out.println(0);
            System.exit(0);
        }

        int answer = getAnswer(N, K);

        System.out.println(answer);
    }

    private static int getAnswer(int N, int K) {
        int answer = 0;

        while (true) {
            int count = 0;
            int tempN = N;

            while (tempN != 0) {
                if (tempN % 2 == 1) {
                    count += 1;
                }

                tempN /= 2;
            }

            if (count <= K) {
                return answer;
            }

            N += 1;
            answer += 1;
        }
    }
}
