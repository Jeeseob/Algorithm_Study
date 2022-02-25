package Graph.Graph1;

import java.util.Arrays;

// DFS를 사용한 방법으로, 시간초과가 난 코드이다.

class SolutionDFS {
    static int[] nodes;
    public int solution(int n, int[][] edge) {
        int answer = 0;

        nodes = new int[n];
        Arrays.fill(nodes,Integer.MAX_VALUE);
        recusiveGraph(n, 1, edge, 0);

        int maxValue = Arrays.stream(nodes).max().getAsInt();
        for(int node : nodes) {
            if(node == maxValue) {
                answer++;
            }
        }
        return answer;
    }
    private void recusiveGraph(int n, int node, int[][] edge, int count) {
        nodes[node-1] = nodes[node-1] > count ?  count : nodes[node-1];

        for(int i = 0; i < edge.length; i++) {
            if(node == edge[i][0] || node == edge[i][1]) {
                int[][] tempEdge = delteEdge(edge, i);
                if(node == edge[i][1]) {
                    recusiveGraph(n, edge[i][0], tempEdge, count + 1);
                }
                else{
                    recusiveGraph(n, edge[i][1], tempEdge, count + 1);
                }
            }
        }
    }
    private int[][] delteEdge(int[][] edge, int tempIndex) {
        int[][] tempEdge = new int[edge.length-1][2];
        int count = 0;

        for (int i = 0; i < edge.length; i++) {
            if (tempIndex != i) {
                tempEdge[i - count] = edge[i];
            }
            else {
                count++;
            }
        }
        return tempEdge;
    }
}
