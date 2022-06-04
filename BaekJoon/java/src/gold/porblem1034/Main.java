package gold.porblem1034;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = getMap(br, N, M);
        int K = Integer.parseInt(br.readLine());

        int max = calc(N, M, K);
        System.out.println(max);
    }

    static boolean isEqual(int[] arr1, int[] arr2, int m){

        for(int i=0; i<m; i++)
            if(arr1[i] != arr2[i])
                return false;

        return true;
    }

    private static int calc(int N, int M, int K) {
        int max = 0;
        for(int i = 0; i< N; i++){
            int zero = countZero(M, i);
            int onRow = 0;

            // 0의 수가 K보다 작으면, 해당하는 행의 모든 불이 켜질 수 없다.
            // 0의 수와 K의 홀/짝이 맞아야 해당하는 행의 모든 불이 켜질 수 있다.
            if(zero <= K && zero % 2 == K % 2){
                max = Math.max(max, getMax(N, M, i, onRow));
            }
        }
        return max;
    }

    private static int getMax(int N, int M, int i, int onRow) {
        for (int j = 0; j < N; j++) {
            if (isEqual(map[i], map[j], M)) {
                onRow++;
            }
        }
        return onRow;
    }

    private static int countZero(int M, int i) {
        int zero = 0;
        for(int j = 0; j< M; j++) {
            if (map[i][j] == 0) zero++;
        }
        return zero;
    }

    private static int[][] getMap(BufferedReader br, int N, int M) throws IOException {
        int[][] tempMap = new int[N][M];
        for(int i = 0; i< N; i++){
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                tempMap[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
            }
        }

        return tempMap;
    }
}