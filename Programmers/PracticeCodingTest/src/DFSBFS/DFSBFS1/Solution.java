package DFSBFS.DFSBFS1;

// https://programmers.co.kr/learn/courses/30/lessons/43165
// DFS/BFS 문제 : 타겟넘버

import java.util.Arrays;

class Solution {
    public int solution(int[] numbers, int target) {
        // 재귀함수 호출
        return  recursiveSol(numbers, target, 0);
    }
    private int recursiveSol(int[] numbers, int target, int temp) {
        int answer = 0;
        // 마지막 숫자까지 반복
        if(numbers.length != 0) {
            // +와 -를 모두 진행
            answer += recursiveSol(Arrays.copyOfRange(numbers, 1, numbers.length), target, temp + numbers[0]);
            answer += recursiveSol(Arrays.copyOfRange(numbers, 1, numbers.length), target, temp - numbers[0]);
        }
        else {
            // 마지막인 경우, target이 temp와 같다면 1 (아니라면 아래의 return으로 0이 반환 된다)
            if(target == temp) {
                return 1;
            }
        }
        return answer;
    }
}
