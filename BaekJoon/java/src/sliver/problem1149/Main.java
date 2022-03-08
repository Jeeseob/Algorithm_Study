package sliver.problem1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "");

        int numberOfHouse = Integer.parseInt(st.nextToken());

        int[][] houses = new int[numberOfHouse][3];
        for(int i = 0; i < numberOfHouse; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 3; j++) {
                houses[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // Dynamic Programming으로 해결

        // houses에 각 노드를 선택했을 때 기준 최소 값을 저장
        for(int i = 1; i < numberOfHouse; i++) {
            for(int j = 0; j < 3; j++) {
                // 더하기 1,2를 하고, 3으로 나눈 나머지 (자기 자신을 제외한 값 2개)
                houses[i][j] += Math.min(houses[i-1][(j+1)%3],houses[i-1][(j+2)%3]);
            }
        }
        System.out.println(Arrays.stream(houses[numberOfHouse - 1]).min().orElse(0));
    }
}
