package sliver.problem11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] line = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            line[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(line);

        int temp = 0;
        int sum = 0;
        for (int i = 0; i < N ; i++) {
            temp += line[i];
            sum += temp;
        }
        System.out.println(sum);
    }
}
