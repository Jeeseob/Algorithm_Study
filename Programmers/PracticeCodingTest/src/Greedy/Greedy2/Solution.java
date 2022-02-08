package Greedy.Greedy1;

// https://programmers.co.kr/learn/courses/30/lessons/42840
// Sort 문제 : 모의고사

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {

        // 학생 답안(찍는 순서)
        int[][] studentAnswers = new int[][]{{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        // {학생이 받은 점수, 학생 index}
        int[][] totalPoint = new int[studentAnswers.length][2];

        // 각 학생별 totalPoint 계산 및 입력
        for(int i = 0; i < answers.length; i++) {
            for (int j = 0; j < totalPoint.length; j++) {
                if (answers[i] == studentAnswers[j][i % studentAnswers[j].length]) {
                    totalPoint[j][0] += 1;
                }
                totalPoint[j][1] = j;
            }
        }
        // 점수를 기반으로 내림차순 정렬
        Arrays.sort(totalPoint, (o1,o2) -> o2[0] - o1[0]);

        int count = totalPoint.length;
        int maxPoint = totalPoint[0][0]; // 내림차순의 가장 첫번째 값이 최대값

        // 최댓값이 몇개인지 count, break 없이 빠져나온다면, count = totalPoint.legth 그대로
        for (int i = 1; i < totalPoint.length; i++) {
            if(totalPoint[i][0] != maxPoint) {
                count = i;
                break;
            }
        }
        int[] answer = new int[count];
        // 정답 갯수만큼 반복하여, index를 정답에 넣는다.
        for (int i = 0; i < answer.length; i++) {
            answer[i] = totalPoint[i][1]+1;
        }

        Arrays.sort(answer);
        return answer;
    }
}