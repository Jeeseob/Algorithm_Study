package Greedy.Greedy4;

// https://programmers.co.kr/learn/courses/30/lessons/42885
// Greedy 문제 : 구명보트

import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int index = 0;

        Arrays.sort(people);

        // 큰 값 부터 순서대로 진행, 만약 가장 작은 값과 더해도, limit 이하라면, 더해준다.
        for(int i = people.length -1 ; i >= 0; i--) {
            if(i < index) {
                break;
            }
            if (limit >= (people[index] + people[i])) {
                index++;
            }
            answer++;
        }
        return answer;
    }
}