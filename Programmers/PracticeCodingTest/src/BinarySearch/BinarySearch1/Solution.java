package BinarySearch.BinarySearch1;

// https://programmers.co.kr/learn/courses/30/lessons/43238
// BinarySearch 문제 : 입국심사

import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        // 최대값으로, 시간이 가장 긴 심사관에게 모든 심사를 받는다고 가정한다.
        long high = (long)Arrays.stream(times).max().getAsInt() * n;
        long middle;
        long low = 0;

        long people;

        // 중간에 중도값이 나올 수 있기 때문에 low와 high를 기준으로 반복문을 만든다.
        while (low <= high) {
            middle = (high + low) / 2;
            people = 0;

            for(int time : times) {
                people += middle / time;
            }

            if(people < n) {
                low = middle+1;
            }

            // answer를 계속 바꿔주며 최적의 값을 찾는다.
            else  {
                high = middle-1;
                answer = middle;
            }
        }
        return answer;
    }
}