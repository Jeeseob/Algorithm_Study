package Heap.heap1;

// https://programmers.co.kr/learn/courses/30/lessons/42626
// Heap 문제 : 더 맵게

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> scovileHeap = new PriorityQueue<>();
        // Heap에 스코빌지수 저장
        for (int tempScoville : scoville) {
            scovileHeap.add(tempScoville);
        }
        // 두개씩 더하고, 원하는 스코빌 지수를 얻지 못할 수 있기 때문에 while이 아닌 for문으로 만듬.
        for(int i = 1; i< scoville.length; i++) {
            // 가장 스코필지수가 낮은 값 두개를 조합
            int minScoville = scovileHeap.poll();
            minScoville = minScoville + scovileHeap.poll()*2;
            // 새로운 스코필지수의 음식을 heap에 넣어 정렬
            scovileHeap.add(minScoville);
            // 스코필 지수가 가장 낮은 음식이 K보다 크면, 완성
            if(scovileHeap.peek() >= K) {
                return i;
            }
        }
        return -1;
    }
}