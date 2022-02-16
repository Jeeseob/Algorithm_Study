package week1.problem1;

import java.util.Arrays;

// 기지국 설치 문제
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int tempIndex = 1;
        int stationIndex = 0;

        // 기지국 위치 정렬
        Arrays.sort(stations);

        while(tempIndex <= n) {

            // 기지국으로 전파가 전달되는 위치에 tempIndex가 위치한 경우,
            if(stationIndex < stations.length && stations[stationIndex] - w <= tempIndex && tempIndex <= stations[stationIndex] + w) {
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
