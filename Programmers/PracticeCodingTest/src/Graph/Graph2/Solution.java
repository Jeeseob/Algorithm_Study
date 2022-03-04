package Graph.Graph2;

// https://programmers.co.kr/learn/courses/30/lessons/49191
// Graph 문제 : 순위

// 부모노드의 수 + 자식노드의 수 = n-1 이면, 순위를 알 수 있다.

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    ArrayList<ArrayList<Integer>> nodeGraph = new ArrayList<>();
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[] counts = new int[n]; // 부모노드 + 자식노드의 값을 저장할 배열

        // 자식노드 구하기(DFS)
        for (int i = 1; i < n+1; i++) {
            nodeGraph.add(new ArrayList<>());
            recursiveDFS(i,i,results);
        }

        for (int i = 0; i < n; i++) {
            // 자식노드 갯수 구하기
            ArrayList<Integer> nodes = nodeGraph.get(i);
            counts[i] += nodes.size();

            // 부모노드 갯수 구하기
            for (Integer node : nodes) {
                //System.out.println("i = "+i+", node = "+node);
                counts[node-1] += 1;
           }
        }

        for (int count : counts) {
            //System.out.println("count = " + count);
            if( count == n -1){
                answer++;
            }
        }

        return answer;
    }

    private void recursiveDFS(int id, int temp, int[][] results) {
        // graph를 돌면서, 현재 노드의 자식노드들을 ArrayList에 넣는다.
        for (int[] result : results) {
            if(result[0] == temp) {
                if(!nodeGraph.get(id-1).contains(result[1])) {
                    nodeGraph.get(id - 1).add(result[1]);
                    recursiveDFS(id, result[1], results);
                }
            }
        }
    }
}
