package Greedy.Greedy6;

// https://programmers.co.kr/learn/courses/30/lessons/42884
// Greedy 문제 : 단속카메라

import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        // 나가는 부분을 기준으로 오름차순 정렬
        Arrays.sort(routes, (o1,o2) -> Integer.compare(o1[1],o2[1]));

        // 현재 자동차의 나가는 부분과, 다음 자동차의 들어오는 부분을 비교해서, 겹치는 부분을 찾는다.
        for (int i = 0; i < routes.length; i++) {
            for (int j = i + 1; j < routes.length; j++) {
                if(routes[i][1] < routes[j][0]) {
                    i = j-1;
                    answer++;
                    break;
                }
            }
        }

        // 마지막부분에 answer++가 되지 않기 때문에 +1
        return answer+1;
    }
}