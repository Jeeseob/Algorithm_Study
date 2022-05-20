package sliver.problem11726;

import java.io.*;

public class Main {
    private static final int INF = 10007;
    private static int[] dynamic;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(br.readLine());
        makeDynamic(length+1);

        bw.write(fibonacci(length) + "\n");
        bw.flush();
        bw.close();
    }

    private static void makeDynamic(int length) {
        dynamic = new int[length];
        dynamic[0] = 1;
        dynamic[1] = 1;
    }

    private static int fibonacci(int tempLength) {
        if (dynamic[tempLength] == 0) {
            dynamic[tempLength] = (fibonacci(tempLength-1) + fibonacci(tempLength-2)) % INF;
        }

        return dynamic[tempLength];
    }
}
