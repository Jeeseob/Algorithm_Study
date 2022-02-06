package StackQueue3;

import java.util.LinkedList;
import java.util.Queue;

// https://programmers.co.kr/learn/courses/30/lessons/42583
// Stack/Queue 문제 : 다리를 지나는 트럭

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> onBridgeQueue = new LinkedList<>(); // 다리를 의미하는 Queue

        // 다리에 모든 칸을 0으로
        for (int i = 0; i < bridge_length; i++) {
            onBridgeQueue.offer(0);
        }

        int index = 0; // 다음 트럭의 index
        int weightOnBreidge = 0; //현재 다리위 트럭 무게의 합
        int answer = 0; // 진행된 초

        while(index < truck_weights.length) {
            answer++;
            // 1초 진행시 마다, 트럭들이 하나씩 앞으로 진행
            weightOnBreidge -= onBridgeQueue.poll();
            // 현재 다리위의 트럭 무게가 다음 트럭을 추가해도 되는 경우, 트럭 추가
            if(weightOnBreidge + truck_weights[index] <= weight) {
                onBridgeQueue.offer(truck_weights[index]);
                weightOnBreidge += truck_weights[index];
                index++;
            }
            // 무게가 가득인 경우, 트럭이 올라가지 않음
            else {
                onBridgeQueue.offer(0);
            }
        }
        // 마지막 트럭이 올라가면 while문이 종료되기 때문에 마지막 트럭이 지나가는 시간(다리의 길이)을 더해줌.
        return answer+bridge_length;
    }
}