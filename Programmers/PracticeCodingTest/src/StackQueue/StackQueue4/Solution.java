package StackQueue.StackQueue4;

// https://programmers.co.kr/learn/courses/30/lessons/42584
// Stack/Queue 문제 : 주식가격

// Stack/Queue를 활용하는 문제인데... 아래 코드가 효율성이 더 좋은 것 같다.
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                // 자신보다 작은 값이 없는 동안 반복
                if (prices[i] > prices[j]) {
                    break;
                }
            }
        }
        return answer;
    }
}