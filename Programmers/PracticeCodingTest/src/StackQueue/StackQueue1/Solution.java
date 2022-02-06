package StackQueue1;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/42586
// Stack/Queue 문제 : 기능개발

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answerArrayList = new ArrayList<>();
        int answerCount = 1;

        // 첫번째 progress의 실행 시간
        int dayCount = (int) Math.ceil((double) (100 - progresses[0]) / speeds[0]);
        for (int i = 1; i < progresses.length; i++) {

            int temp = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            // progress의 실행시간이 기준 값(이전 값) 보다 큰 경우, ArrayList에 추가하고 새로운 기준 값을 만든다.
            if (dayCount < temp) {
                dayCount = temp;
                answerArrayList.add(answerCount);
                // 본인부터 count 하기 때문
                answerCount = 1;
            }
            // porgress의 실행시간이 기준값(이전 값) 보다 작거나 같은 경우 동시에 배포한다.
            else {
                answerCount++;
            }
        }
        // 마지막 연산값은 반복문에서 답에 들어가지 않기 때문에 정답에 추가한다.
        answerArrayList.add(answerCount);

        // 정답 기준에 맞춰 ArrayList를 배열로 변환
        int[] answer = answerArrayList.stream().filter(i -> i != 0).mapToInt(i -> i).toArray();
        return answer;
    }

    public int[] solution2(int[] progresses, int[] speeds) {
        Queue<Integer> answerQueue = new LinkedList<>();
        ArrayList<Integer> answerArrayList = new ArrayList<>();
        int answerCount = 1;

        // Queue에 필요한 필요개발 일자 넣기
        for(int i = 0; i < progresses.length; i++) {
            answerQueue.offer((int) Math.ceil((double)(100 - progresses[i]) / speeds[i]));
        }

        // 기준값 지정
        int dayCount = answerQueue.poll();
        for(int i = 1; i < progresses.length; i++) {
            // 현재 값 지정
            int temp = answerQueue.poll();
            // 기준값 보다 현재값이 큰 경우, 배포할 수 없음.
            if(dayCount < temp) {
                answerArrayList.add(answerCount);
                answerCount = 1;
                dayCount = temp;
            }
            else {
                answerCount++;
            }
        }
        answerArrayList.add(answerCount);

        // 정답 기준에 맞춰 ArrayList를 배열로 변환
        int[] answer = answerArrayList.stream().filter(i->i!=0).mapToInt(i->i).toArray();
        return answer;
    }
}