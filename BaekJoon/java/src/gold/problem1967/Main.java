package gold.problem1967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static ArrayList<Edge>[] edgeArrayLists;
    private static int numberOfNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        numberOfNode = Integer.parseInt(st.nextToken());

        edgeArrayLists = new ArrayList[numberOfNode+1];
        for (int i = 1; i < numberOfNode+1; i++) {
            edgeArrayLists[i] = new ArrayList<>();
        }

        // 간선의 갯수는 numberOfNode-1이다.
        for (int i = 1; i < numberOfNode; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int parentNode = Integer.parseInt(st.nextToken());
            int childNode = Integer.parseInt(st.nextToken());
            int edgeWeight = Integer.parseInt(st.nextToken());

            // 지름을 구하기 위해서는 child에서 parent로 가는 경우도 존재할 수 있기 때문에 양방향으로 저장.
            edgeArrayLists[parentNode].add(new Edge(childNode, edgeWeight));
            edgeArrayLists[childNode].add(new Edge(parentNode, edgeWeight));
        }

        // 문제 해결방법

        // 서로 가장 먼 노드 중 하나는 루트 노드를 기준으로 가장 먼 노드이다.
        // 루트 노드를 기준으로 가장 먼 노드에서 가장 먼 노드를 찾으면 두 노드의 거리가 트리의 지름이다.

        // 다익스트라 알고리즘을 2번 사용하면 값이 나온다.
        int[] data = findFarthestNode(1);
        data = findFarthestNode(data[0]);

        System.out.println(data[1]);
    }

    // 다익스트라 알고리즘을 활용하여, 가장 먼 노드를 찾는다.
    private static int[] findFarthestNode(int startNode) {
        PriorityQueue<Edge> edges = new PriorityQueue<>();
        Boolean[] visited = new Boolean[numberOfNode];
        int[] nodes = new int[numberOfNode];

        edges.add(new Edge(startNode, 0));
        Arrays.fill(visited, false);
        Arrays.fill(nodes, Integer.MAX_VALUE);
        nodes[startNode-1] = 0;

        while (!edges.isEmpty()) {
            Edge tempEdge = edges.poll();

            for(Edge nextEdge : edgeArrayLists[tempEdge.getNode()]) {
                if (visited[nextEdge.getNode() - 1]) continue;
                visited[nextEdge.getNode() - 1] = true;

                if (nodes[nextEdge.getNode() - 1] > nextEdge.getWeight() + nodes[tempEdge.getNode() - 1]){
                    nodes[nextEdge.getNode() - 1] = nextEdge.getWeight() + nodes[tempEdge.getNode() - 1];
                }
                edges.add(new Edge(nextEdge.getNode(), nodes[nextEdge.getNode() - 1]));
            }
        }

        int maxWeight = Arrays.stream(nodes).max().orElse(-1);
        int maxNode = 0;
        for (int i = 0; i < numberOfNode; i++) {
            if(nodes[i] > nodes[maxNode]) {
                maxNode = i;
            }
        }

        return new int[]{maxNode+1, maxWeight};
    }

}

class Edge implements Comparable<Edge>{
    private int node;
    private int weight;

    public Edge(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    public int getNode() {
        return node;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge edge) {
        return weight - edge.getWeight();
    }
}
