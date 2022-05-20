package sliver.problem11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int numberOfNode = Integer.parseInt(st.nextToken());
        int numberOfEdge = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] nodes = initArrayLists(numberOfNode);
        getNodes(br, numberOfEdge, nodes);

        int answer = getAnswer(numberOfNode, nodes);
        System.out.println(answer);
    }

    private static ArrayList<Integer>[] initArrayLists(int numberOfNode) {
        ArrayList<Integer>[] nodes = new ArrayList[numberOfNode +1];
        for (int i = 0; i <= numberOfNode; i++) {
            nodes[i] = new ArrayList<>();
        }
        return nodes;
    }

    private static int getAnswer(int numberOfNode, ArrayList<Integer>[] nodes) {
        boolean[] visited = new boolean[numberOfNode+1];
        Arrays.fill(visited, false);

        int answer = 0;
        for (int i = 1; i <= numberOfNode; i++) {
            if(visited[i]) continue;

            Queue<Integer> nodeQueue = new LinkedList<>();
            nodeQueue.offer(i);

            while (!nodeQueue.isEmpty()) {
                int tempNode = nodeQueue.poll();
                if(visited[tempNode]) continue;
                visited[tempNode] = true;

                for (int j = 0; j < nodes[tempNode].size(); j++) {
                    nodeQueue.offer(nodes[tempNode].get(j));
                }
            }
            answer++;
        }
        return answer;
    }

    private static void getNodes(BufferedReader br, int numberOfEdge, ArrayList<Integer>[] nodes) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < numberOfEdge; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            nodes[node1].add(node2);
            nodes[node2].add(node1);
        }
    }
}
