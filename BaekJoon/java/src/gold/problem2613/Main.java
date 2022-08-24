package gold.problem2613;

import java.io.*;
import java.util.*;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/08/24
 * @Problem : https://www.acmicpc.net/problem/2613
 */

public class Main {
    private static int N;
    private static int M;
    private static int result;

    private static int[] balls;
    private static int[] line;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        line = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            line[i] = Integer.parseInt(st.nextToken());
        }

        balls = new int[M];
        binarySearch();
        System.out.println(result);

        groupCheck();
        for(int i = 0; i < M; i++){
            System.out.print(balls[i] + " ");
        }
    }

    // 그룹 개수 맞추기(0 개수 그룹 없애기)
    public static void groupCheck(){
        int idx = 0;
        for(int i = 0; i < M; i++){
            if(balls[i] == 0){
                idx = i-1;
                balls[i]++;
                while(true){
                    if(balls[idx] != 1){
                        break;
                    }
                    idx--;
                }
                balls[idx]--;
            }
        }
    }

    public static void binarySearch(){
        int min = 1;
        int max = Arrays.stream(line).sum();

        while(min <= max){
            int mid = (min+max)/2;
            if(isPossible(mid)){
                max = mid-1;
                result = mid;
            }else{
                min = mid+1;
            }
        }
    }

    public static boolean isPossible(int mid){
        int groupSum = 0;
        int groupIdx = 0;

        int[] groupNum = new int[M];

        for(int i = 0; i < N; i++){
            if(mid < line[i]){
                return false;
            }

            if(groupSum + line[i] <= mid){
                groupSum += line[i];
            }else{
                groupSum = line[i];
                groupIdx++;
            }
            if(groupIdx == M){
                return false;
            }
            groupNum[groupIdx]++;
        }

        balls = groupNum;
        return true;
    }
}