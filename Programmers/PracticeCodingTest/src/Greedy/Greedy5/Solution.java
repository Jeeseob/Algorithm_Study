package Greedy.Greedy5;

// https://programmers.co.kr/learn/courses/30/lessons/42861
// Greedy 문제 : 섬 연결하기

import java.util.Arrays;

class Solution {

    static int[] kruskalArray;

    public int solution(int n, int[][] costs) {
        int answer = 0;

        // costs를 가중치를 기준으로 오름차순 정렬
        Arrays.sort(costs, (int[] o1, int[] o2) -> o1[2] - o2[2]);

        // Kruskal Algorithm을 사용하기위해, 배열을 선언한다.
        // index는 섬의 번호이고, 값은 부모 섬의 번호
        kruskalArray = new int[n];
        // index를 값으로 초기화
        for (int i = 0; i < n; i++) {
            kruskalArray[i] = i;
        }

        for (int[] node : costs) {
            // 다리를 연결하는 섬의 부모노드의 값을 가져온다.
            int startParent = findParentNode(node[0]);
            int endParent = findParentNode(node[1]);

            if(startParent != endParent) {
                answer += node[2];
                // 두 섬을 연결
                kruskalArray[endParent] = startParent;

            }
        }

        // 0부터 시작.. 작은 값쪽으로 타고 들어간다.
        return answer;
    }

    // 노드(index)를 받아서 연결된 부모노드(index)를 반환
    private int findParentNode(int node) {
        if(kruskalArray[node] == node) {
            return node;
        }
        // 재귀를 통해, 가장 처음 부모노드의 값을 가져온다.
        kruskalArray[node] = findParentNode(kruskalArray[node]);

        return kruskalArray[node];
    }
}