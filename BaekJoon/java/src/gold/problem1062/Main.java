package gold.problem1062;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final String data = "actni";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String[] words = getStrings(br, N);

        if (K < 5) {
            System.out.println(0);
            System.exit(0);
        }



    }

    private static String[] getStrings(BufferedReader br, int N) throws IOException {
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            words[i] = temp.substring(4, temp.length() - 4);
        }
        return words;
    }
}
