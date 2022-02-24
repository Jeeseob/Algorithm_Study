package BinarySearch.BinarySearch2;

// https://programmers.co.kr/learn/courses/30/lessons/43236
// BinarySearch 문제 : 징검다리

import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int start = 0;
        int end = distance;
        int middle = 0;

        // 순서대로 진행
        Arrays.sort(rocks);

        while(start <= end) {
            // 최소, 최대값의 중간값으로 하기 때문에 start와 end를 더해준다.
            middle = (end + start) / 2;
            int beforeRock =  0;
            int count = 0;
            for(int rock : rocks) {
                if(rock - beforeRock < middle) {
                    count++; // 기준 값보다 작은 경우, 해당 돌을 깨서 거리를 늘린다.
                }
                else {
                    beforeRock = rock; // 기준 값보다 높은 경우, 돌을 깰 필요가 없다. 기준돌을 옮긴다.
                }
            }

            // 마지막돌과 도착지에 대한 비교
            if(distance - beforeRock < middle) {
                count++;
            }

            if(count <= n){
                answer = middle > answer ? middle : answer;
                start = middle + 1;
            }
            else {
                end = middle - 1;
            }
        }
        return answer;
    }
}