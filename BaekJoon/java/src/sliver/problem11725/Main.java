package sliver.problem11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] answers;
    static List<Integer>[] tree;
    static boolean[] visited;
    static int numberOfNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numberOfNode = Integer.parseInt(br.readLine());

        tree = new ArrayList[numberOfNode+1];
        answers = new int[numberOfNode+1];
        for(int i = 1; i <= numberOfNode; i++) {
            tree[i] = new ArrayList<>();
        }

        visited = new boolean[numberOfNode+1];
        for(int i = 0; i < numberOfNode-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            tree[first].add(second);
            tree[second].add(first);
        }

        searchTree(1);

        for(int i = 2; i <= numberOfNode; i++) {
            System.out.println(answers[i]);
        }
    }

    //DFS 활용
    private static void searchTree(int tempNode) {
        visited[tempNode] = true;

        for(int node : tree[tempNode]) {
            if(!visited[node]) {
                answers[node] = tempNode;
                searchTree(node);
            }
        }
    }
}
