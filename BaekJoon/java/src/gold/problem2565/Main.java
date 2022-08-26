package gold.problem2565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/08/26
 * @Problem : https://www.acmicpc.net/problem/2565
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Point[] pole = new Point[N];
        int[] dynamic = new int[N];
        Arrays.fill(dynamic, 1);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            pole[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(pole);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(pole[i].getB() > pole[j].getB()) {
                    dynamic[i] = Math.max(dynamic[i], dynamic[j] + 1);
                }
            }
        }
        System.out.println(N - (Arrays.stream(dynamic).max().orElse(0)));
    }
}

class Point implements Comparable<Point> {
    private int a;
    private int b;

    public Point(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    @Override
    public int compareTo(Point o) {
        return this.a - o.getA();
    }
}