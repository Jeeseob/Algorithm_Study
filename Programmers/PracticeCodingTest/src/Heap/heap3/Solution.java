package Heap.heap2;

// https://programmers.co.kr/learn/courses/30/lessons/42627
// Heap 문제 : 디스크 컨트롤러

import java.util.Arrays;
import java.util.PriorityQueue;

class Process implements Comparable<Process> {
    private int requestTime;
    private int workingTime;

    public Process(int[] job) {
        this.requestTime = job[0];
        this.workingTime = job[1];
    }

    public int getRequestTime() {
        return requestTime;
    }

    public int getWorkingTime() {
        return workingTime;
    }

    @Override
    public int compareTo(Process process) {
        return this.workingTime-process.getWorkingTime();
    }

}

class Solution {
    int total = 0; // 요청부터 종료까지 시간의 합
    int count = 0; // 현재까지 진행된 순수 시간

    public int solution(int[][] jobs) {
        PriorityQueue<Process> waitHeap = new PriorityQueue<>();// 요청 후 대기중인 jobs

        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        int index = 0;
        while (index < jobs.length || !waitHeap.isEmpty()) {
            while(index < jobs.length && jobs[index][0] <= count) {
                waitHeap.add(new Process(jobs[index++]));
            }
            if (waitHeap.isEmpty()) {
                count = jobs[index][0];
            }
            else {
                Process temp = waitHeap.poll();
                total += temp.getWorkingTime() + count - temp.getRequestTime();
                count += temp.getWorkingTime();
            }
        }
        int answer = total/jobs.length;
        return answer;
    }
}

