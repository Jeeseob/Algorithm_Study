package Heap.heap3;

// https://programmers.co.kr/learn/courses/30/lessons/42628
// Heap 문제 : 이중우선순위큐

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        // 내림차순, 오름차순으로 각각 하나씩 Heap을 만든다.
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        PriorityQueue<Integer> reversePriorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        int index = 0; // 현재 이중우선순위큐에 존재하는 값의 수
        for (String operation : operations) {
            // operation을 문자와 숫자로 구분한다.
            String[] operationData = operation.split(" ");

            // 값을 추가하는 경우
            if(operationData[0].equals("I")) {
                // 모든 Heap에 값을 추가한다.
                priorityQueue.offer(Integer.parseInt(operationData[1]));
                reversePriorityQueue.offer(Integer.parseInt(operationData[1]));
                index++;
            }
            // 값을 제거하는 경우
            else {
                if (index > 0) {
                    index--;
                    // 명령어에 따라 특정 Heap에서 값을 제거한다.
                    if (operationData[1].equals("1")) {
                        reversePriorityQueue.poll();
                    } else {
                        priorityQueue.poll();
                    }
                }
            }
            // index가 0인경우, 내부에 데이터가 없어야 하지만 실제로는 데이터가 나누어져 들어가 있기 때문에, 이후에 추가 및 제거시 문제가 생길 수 있어 초기화한다.
            if(index <= 0) {
                priorityQueue = new PriorityQueue<>();
                reversePriorityQueue = new PriorityQueue<>(Collections.reverseOrder());
            }
        }
        if(index == 0) {
            return new int[]{0,0};
        }
        else {
            return new int[]{reversePriorityQueue.poll(), priorityQueue.poll()};
        }
    }
}