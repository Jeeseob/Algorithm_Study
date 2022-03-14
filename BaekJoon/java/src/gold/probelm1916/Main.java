package gold.probelm1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static ArrayList<Edge>[] cityArrayList;

    private static int numberOfCity;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 도시의 수
        numberOfCity = Integer.parseInt(st.nextToken());

        cityArrayList = new ArrayList[numberOfCity + 1];

        for (int i = 1; i <= numberOfCity; i++) {
            cityArrayList[i] = new ArrayList<>();
        }

        // 버스의 수
        st = new StringTokenizer(br.readLine(), " ");
        int numberOfBus = Integer.parseInt(st.nextToken());

        for (int i = 0; i < numberOfBus; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int busNumber = Integer.parseInt(st.nextToken());

            cityArrayList[start].add(new Edge(end, busNumber));
        }
        st = new StringTokenizer(br.readLine(), " ");
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        System.out.println(searchCity(startCity, endCity));

    }

    // 다익스트라 알고리즘
    private static int searchCity(int startCity, int endCity) {
        PriorityQueue<Edge> cityPriorityQueue = new PriorityQueue<>();
        cityPriorityQueue.add(new Edge(startCity, 0));

        Boolean[] visited = new Boolean[numberOfCity];
        Arrays.fill(visited, false);

        int[] answers = new int[numberOfCity];
        Arrays.fill(answers, Integer.MAX_VALUE);
        answers[startCity-1] = 0;

        while (!cityPriorityQueue.isEmpty()) {
            Edge tempEdge = cityPriorityQueue.poll();

            if(visited[tempEdge.getNode()-1]) continue;
            visited[tempEdge.getNode()-1] = true;

            for (Edge nextEdge : cityArrayList[tempEdge.getNode()]) {
                if (answers[nextEdge.getNode() - 1] > answers[tempEdge.getNode() - 1] + nextEdge.getWeight()) {
                    answers[nextEdge.getNode() - 1] = answers[tempEdge.getNode() - 1] + nextEdge.getWeight();
                }
                cityPriorityQueue.add(new Edge(nextEdge.getNode(), answers[nextEdge.getNode() - 1]));
            }
        }
        return answers[endCity - 1];
    }
}

class Edge implements Comparable<Edge> {
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