package StackQueue2;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/42587
// Stack/Queue 문제 : 프린터

// 프린트 문서의 정보
class DocumentData {
    private int priorty;
    private int location;

    public DocumentData(int priorty, int location) {
        this.priorty = priorty;
        this.location = location;
    }

    public int getPriorty() {
        return priorty;
    }

    public int getLocation() {
        return location;
    }
}

class Solution {


    public int solution(int[] priorities, int location) {

        Queue<DocumentData> documentDataQueue = new LinkedList<>(); // 대기목록
        ArrayList<Integer> indexArrayList = new ArrayList<>(); // 프린트된 문서 목록(index)

        Boolean print = false;
        int answer = 0;

        // 대기목록에 문서 저장
        for(int i = 0; i < priorities.length; i++) {
            DocumentData documentData = new DocumentData(priorities[i], i);
            documentDataQueue.offer(documentData);
        }

        // 모든 문서를 프린트할 때까지 반복
        while(!documentDataQueue.isEmpty()) {
            // 대기목록 최상단의 문서를 현재 문서로 정의
            DocumentData tempDocument = documentDataQueue.poll();

            for(int i = 0; i < priorities.length; i++ ){
                // 프린트되지 않은 문서만 비교군으로 설정
                if(!indexArrayList.contains(i)) {
                    // 비교군 중, 현재문서보다 우선순위가 먼저인게 있는 경우, 프린트 하지 않고, 대기목록 마지막에 다시 추가
                    if(tempDocument.getPriorty() < priorities[i]) {
                        print = false;
                        documentDataQueue.offer(tempDocument);
                        break;
                    }
                    // 모든 반복문을 통과하는 경우 해당 문서를 출력
                    else {
                        print = true;
                    }
                }
            }
            if(print == true) {
                // 출력
                answer++;
                indexArrayList.add(tempDocument.getLocation());
                // 출력된 문서가 location에 해당하는 경우 return
                if(location == tempDocument.getLocation()){
                    return answer;
                }
            }

        }
        return answer;
    }
}