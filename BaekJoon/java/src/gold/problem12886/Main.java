package gold.problem12886;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Data {
    private int a;
    private int b;
    private int c;

    public Data(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int sum = a + b + c;

        // 세 갮의 합이 3으로 나누어 떨어지지 않으면, 같은 값이 나올 수 없다.
        if (sum % 3 != 0) {
            System.out.println(0);
            System.exit(0);
        }


        boolean[][] visited = new boolean[sum+1][sum+1];

        Queue<Data> dataQueue = new LinkedList<>();
        dataQueue.add(new Data(a, b, c));

        while (!dataQueue.isEmpty()) {
            Data tempData = dataQueue.poll();
            int tempA = tempData.getA();
            int tempB = tempData.getB();
            int tempC = tempData.getC();

            if (tempA == tempB && tempB == tempC) {
                System.out.println(1);
                System.exit(0);
            }

            int tempMax = Math.max(tempA, Math.max(tempB, tempC));
            int tempMin = Math.min(tempA, Math.min(tempB, tempC));
            if (visited[tempMax][tempMin]) continue;

            visited[tempMax][tempMin] = true;

            if (tempA != tempB) {
                dataQueue.add(new Data(Math.max(tempA, tempB) - Math.min(tempA, tempB), Math.min(tempA, tempB) * 2, tempC));
            }
            if (tempB != tempC) {
                dataQueue.add(new Data(Math.max(tempC, tempB) - Math.min(tempC, tempB), Math.min(tempC, tempB) * 2, tempA));
            }
            if (tempA != tempC) {
                dataQueue.add(new Data(Math.max(tempA, tempC) - Math.min(tempA, tempC), Math.min(tempA, tempC) * 2, tempB));
            }

        }
        System.out.println(0);
    }
}
