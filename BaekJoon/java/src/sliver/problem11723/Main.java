package sliver.problem11723;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static Boolean[] set;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        set = new Boolean[21];
        Arrays.fill(set, false);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String operator = st.nextToken();

            int temp = 0;
            if (!operator.equals("all") && !operator.equals("empty")) {
                temp = Integer.parseInt(st.nextToken());
            }

            switch (operator) {
                case "add":
                    set[temp] = true;
                    break;
                case "remove":
                    set[temp] = false;
                    break;
                case "check":
                    if (set[temp]) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;

                case "toggle":
                    set[temp] = !set[temp];
                    break;
                case "empty":
                    Arrays.fill(set, false);
                    break;
                case "all":
                    Arrays.fill(set, true);
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}

