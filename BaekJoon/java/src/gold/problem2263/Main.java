package gold.problem2263;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int[][] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int numberOfNode = Integer.parseInt(st.nextToken());

        nodes = new int[2][numberOfNode]; // 0 : 포스트 오더, 1 : 인 오더

        for(int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < numberOfNode; j++) {
                nodes[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 포스트 오더 기준 마지막 -> root
        // 인오더는 root를 기준으로 먼저 나오면, 왼쪽, 나중에 나오면 오른쪽.

        searchNode(0,numberOfNode - 1, 0, numberOfNode - 1);

    }

    // 현재 노드를 출력하고, 왼쪽먼저 쭉쭉 재귀로 가면 됨.
    private static void searchNode(int inStart, int inEnd, int postStart, int postEnd){

        if(inStart > inEnd || postStart > postEnd) return;

        // 자기자신 출력 (preorder)
        int tempRoot = nodes[1][postEnd];
        System.out.print(tempRoot + " ");

        int left = inStart;
        // root보다 왼쪽에 있는 node의 최대 index
        for(int i = inStart; i <= inEnd; i++) {
            if(nodes[0][i] == tempRoot) {
                left = i;
                break;
            }
        }
        searchNode(inStart, left - 1, postStart,  postStart + left - inStart - 1);
        searchNode(left + 1, inEnd, postStart + left - inStart,postEnd - 1);
    }
}
//10
//2 4 3 1 6 9 8 5 7 10
//4 3 2 9 8 6 10 7 5 1
