package DFSBFS.DFSBFS2;

// https://programmers.co.kr/learn/courses/30/lessons/43162
// DFS/BFS 문제 : 네트워크

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] answerArray = new int[n];

        // 부분 네트워크를 찾기위해 재귀함수를 반복
        for(int i = 0; i < n; i++) {
            // 연결되지 않은 Node를 시작점으로 DFS
            if(answerArray[i] != 1) {
                recursiveSol(n, computers, answerArray, i);
                answer++;
            }
        }
        return answer;
    }

    private int[] recursiveSol(int n, int[][] computers, int[] answerArray,int temp) {
        // 현재 Node는 연결됨.
        answerArray[temp] = 1;
        for(int i = 0; i < n; i++) {
            // 현재노드와 연결된 노드 중, 중복이 아닌 노드를 DFS로 탐색
            if (i != temp && computers[temp][i] == 1 && answerArray[i] != 1) {
                recursiveSol(n, computers, answerArray, i);
            }
        }
        return answerArray;
    }
}
