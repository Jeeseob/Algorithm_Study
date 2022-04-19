package gold.problem14938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int numberOfNode;
    private static int searchScope; // 수색범위
    private static int numberOfEdge;

    private static int[] items;
    private static ArrayList<Edge>[] edges;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        readConsole(br);

        items = new int[numberOfNode+1];
        makeItems(br);

        edges = new ArrayList[items.length+1];
        makeEdges(br);

        System.out.println(calc(numberOfNode));
    }

    private static void readConsole(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        numberOfNode = Integer.parseInt(st.nextToken());
        searchScope = Integer.parseInt(st.nextToken());
        numberOfEdge = Integer.parseInt(st.nextToken());
    }

    private static int calc(int numberOfNode) {
        int answer = 0;

        for (int i = 1; i <= numberOfNode; i++) {
            answer = Math.max(answer, calcNode(i));
        }

        return answer;
    }

    private static void makeEdges(BufferedReader br) throws IOException {
        StringTokenizer st;
        for (int i = 1; i < edges.length; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 0; i < numberOfEdge; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[startNode].add(new Edge(endNode, weight));
            edges[endNode].add(new Edge(startNode, weight));
        }
    }

    private static void makeItems(BufferedReader br) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < items.length; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static int calcNode(int startNode) {
        PriorityQueue<Edge> nodePriorityQueue = new PriorityQueue<>();
        nodePriorityQueue.offer(new Edge(startNode, 0));

        Boolean[] visited = new Boolean[numberOfNode+1];
        Arrays.fill(visited, false);

        int[] scopes = new int[numberOfNode + 1];
        Arrays.fill(scopes, Integer.MAX_VALUE);
        scopes[startNode] = 0;

        while (!nodePriorityQueue.isEmpty()) {
            Edge tempEdge = nodePriorityQueue.poll();
            int tempNode = tempEdge.getEndNode();

            if (!visited[tempEdge.getEndNode()]) {
                visited[tempEdge.getEndNode()] = true;

                for (Edge nextEdge : edges[tempNode]) {
                    if (!visited[nextEdge.getEndNode()] && scopes[nextEdge.getEndNode()] > scopes[tempNode] + nextEdge.getWeigth()) {
                        scopes[nextEdge.getEndNode()] = scopes[tempNode] + nextEdge.getWeigth();
                        nodePriorityQueue.add(new Edge(nextEdge.getEndNode(), scopes[nextEdge.getEndNode()]));
                    }
                }
            }
        }


        int tempAnswer = 0;
        for (int i = 0; i < scopes.length; i++) {
            if(searchScope >= scopes[i]) {
                tempAnswer += items[i];
            }
        }

        return tempAnswer;
    }
}

class Edge implements Comparable<Edge> {
    private int endNode;
    private int weigth;

    public Edge(int endNode, int weigth) {
        this.endNode = endNode;
        this.weigth = weigth;
    }

    public int getWeigth() {
        return weigth;
    }

    public int getEndNode() {
        return endNode;
    }

    @Override
    public int compareTo(Edge node) {
        return this.weigth - node.getWeigth();
    }
}
