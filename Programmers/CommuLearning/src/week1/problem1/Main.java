package week1.problem1;

import java.util.Arrays;

// 기지국 설치 문제

// 문제를 잘 읽자, 기지국이 애초에 정렬되서 주어진다고 함.

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int tempIndex = 1;
        int stationIndex = 0;

        // 기지국 위치 정렬
        //Arrays.sort(stations);

        while(tempIndex <= n) {

            // 기지국으로 전파가 전달되는 위치에 tempIndex가 위치한 경우,
            // 기지국이 정렬되어 있어 "&& tempIndex <= stations[stationIndex] + w" 불필요
            if(stationIndex < stations.length && stations[stationIndex] - w <= tempIndex) {
                tempIndex = stations[stationIndex] + w + 1;
                stationIndex++;
            }
            // 현재 위치에 전파가 도달하지 않는 경우,
            else {
                tempIndex += 2 * w + 1;
                answer++;
            }
        }
        return answer;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(11, new int[]{4,7}, 1));
    }
}
