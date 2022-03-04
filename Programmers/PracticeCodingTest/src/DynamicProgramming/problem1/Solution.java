package DynamicProgramming.problem1;

// https://programmers.co.kr/learn/courses/30/lessons/42895
// DynamicProgramming 문제 : N으로 표현

class Solution {
    private int answer;
    public int solution(int N, int number) {
        answer = Integer.MAX_VALUE;
        recursiveDFS(0, 0, N, number);

        if (answer == Integer.MAX_VALUE) {
            return -1;
        }
        return answer;
    }

    private void recursiveDFS(int tempNumber, int count, int N, int number) {
        if(count > 8) {
            return;
        }

        if(tempNumber == number) {
            // 가장 작은 값을 answer로 해야한다.
            answer = answer > count ? count : answer;
            return;
        }

        int multiN = 0;
        for(int i = 1; i < 9-count; i++) {
            // 4칙연산 없이 N을 여러개 배치하는 경우
            multiN = multiN*10+N;
            // DFS
            recursiveDFS(tempNumber + multiN, count+i, N, number);
            recursiveDFS(tempNumber - multiN, count+i, N, number);
            recursiveDFS(tempNumber * multiN, count+i, N, number);
            recursiveDFS(tempNumber / multiN, count+i, N, number);
        }
    }
}
