package gold.problem2263;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        //System.out.print(nodes[1][numberOfNode-1] +" "); // root

        searchNode(0,numberOfNode, 0, numberOfNode);
        // 프리 오더는 처음에 root
    }

    // 현재 노드를 출력하고, 왼쪽먼저 쭉쭉 재귀로 가면 됨.
    private static void searchNode(int preStart, int preEnd, int inStart, int inEnd){

        // 자기자신 출력 (preorder)
        int tempRoot = nodes[1][inEnd-1];
        System.out.print(tempRoot + " ");

        int left = 0;
        // 오른쪽 왼쪽 node의 갯수 파악.
        for(int i = preStart; i < preEnd; i++) {
            if(nodes[0][i] == tempRoot) {
                break;
            }
            left++;  // left는 왼쪽 node의 갯수
        }
        // right는 오른쪽 node의 갯수

        // left
        if(left != 0) {
            System.out.println("left = " + left);
            searchNode(preStart, preStart + left, inStart, inEnd - (preEnd - left));
        }

        // right
        if(left != preEnd - preStart - 1) {
            System.out.println("right = " + (preEnd - preStart - left));
            searchNode(preStart + left, preEnd, preStart + left,inEnd-1);
        }
    }
}
//10
//2 4 3 1 6 9 8 5 7 10
//4 3 2 9 8 6 10 7 5 1