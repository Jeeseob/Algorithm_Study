package Graph.Graph1;

// https://programmers.co.kr/learn/courses/30/lessons/49189
// Graph 문제 : 가장 먼 노드

// 풀이는 되었지만, 시간이 너무 오래걸렸다. 더 효율적인 방법은 없는지 찾아보자.

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] visitedNodes;

    public int solution(int n, int[][] edge) {
        int answer = 0;
        visitedNodes = new int[n+1]; // 노드가 1번부터 시작하기 때문에 n+1로 선언
        Arrays.fill(visitedNodes, -1); // 방문한적 없는 노드처리
        Queue<Integer> nodesQueue = new LinkedList<>();
        nodesQueue.add(1);
        visitedNodes[1] = 0; // 1번 노드는 방문한 것으로

        //BFS
        while(!nodesQueue.isEmpty()) {
            int tempNode = nodesQueue.poll();

            for(int i = 0; i < edge.length; i++) {
                if(edge[i][0] == tempNode && visitedNodes[edge[i][1]] == -1) {
                    nodesQueue.add(edge[i][1]);
                    visitedNodes[edge[i][1]] = visitedNodes[tempNode] + 1;
                }
                else if(edge[i][1] == tempNode && visitedNodes[edge[i][0]] == -1) {
                    nodesQueue.add(edge[i][0]);
                    visitedNodes[edge[i][0]] = visitedNodes[tempNode] + 1;
                }
            }
        }

        // 가장 먼 노드의 값을 구한다.
        int maxValue = Arrays.stream(visitedNodes).max().getAsInt();
        for(int node : visitedNodes) {
            if(node == maxValue) {
                answer++;
            }
        }
        return answer;

    }
}
