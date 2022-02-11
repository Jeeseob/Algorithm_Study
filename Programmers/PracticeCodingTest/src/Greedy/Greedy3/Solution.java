package Greedy.Greedy3;

// https://programmers.co.kr/learn/courses/30/lessons/42883
// Greedy 문제 : 큰 수 만들기

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int index = 0;

        // 마지막까지 제거할 값이 존재하려면, 뒤에 k개 이상 남겨둬야 한다.
        for(int i = 0; i < number.length() - k; i++) {
            char maxNum = '0';
            // k+i를 하면, i 뒷부분의 수만큼 반복할 수 있다.
            for(int j = index; j <= k + i; j++) {
                // 해당하는 부분에서 가장 큰 값을 찾는다.
                if(maxNum < number.charAt(j)) {
                    maxNum = number.charAt(j);
                    // maxNum 변경시, index(현재 위치)도 증가시켜, 중복을 막는다.
                    index = j + 1;
                }
            }
            answer.append(maxNum);
        }
        return answer.toString();
    }
}