package sliver.problem1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int height = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] triangle = new ArrayList[height];
        for (int i = 0; i < height; i++) {
            triangle[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j <= i; j++) {
                triangle[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        // 두번째 줄 부터 가능한 node 2개 중 큰 값을 더한다.
        for (int i = 1; i < height; i++) {
            triangle[i].set(0, triangle[i].get(0) + triangle[i-1].get(0));
            triangle[i].set(i, triangle[i].get(i) + triangle[i - 1].get(i - 1));
            for (int j = 1; j < i; j++) {
                triangle[i].set(j, triangle[i].get(j) + Math.max(triangle[i - 1].get(j - 1), triangle[i - 1].get(j)));
            }
        }
        System.out.println(triangle[height-1].stream().max(Integer::compareTo).orElse(-1));
    }
}