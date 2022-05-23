package platinum.problem14003;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(br.readLine());

        long[] numbers = new long[length];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < length; i++) {
            numbers[i] = Long.parseLong(st.nextToken());
        }





    }
}
