package gold.problem1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 그래프 관련 알고리즘을 추가로 공부하자

public class Main {

    static int[] distance;
    static List<Edge>[] map;
    static int V;

    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        map = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            map[i] = new ArrayList<>();
        }

        distance = new int[V];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken()) - 1]
                    .add(new Edge(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }


        dijkstra(K - 1);


        // 출력
        for (int i = 0; i < V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    // 다익스트라 알고리즘 활용
    public static void dijkstra(int start) {
        PriorityQueue<Edge> edgePriorityQueue = new PriorityQueue<>();
        distance[start] = 0;
        edgePriorityQueue.offer(new Edge(start, distance[start]));

        while (!edgePriorityQueue.isEmpty()) {
            Edge temp = edgePriorityQueue.poll();

            if (temp.getWeight() > distance[temp.getNode()])
                continue;

            // 새로운 경로가 더 효율적인 경우만 계산
            for (Edge edge : map[temp.getNode()]) {
                if (distance[edge.getNode()] > temp.getWeight() + edge.getWeight()) {
                    distance[edge.getNode()] = temp.getWeight() + edge.getWeight();
                    edgePriorityQueue.offer(new Edge(edge.getNode(), distance[edge.getNode()]));

                }
            }
        }

    }
}

class Edge implements Comparable<Edge> {
    private int node;
    private int weight;

    public Edge(int v, int w) {
        this.node = v;
        this.weight = w;
    }

    public int getNode() {
        return node;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}