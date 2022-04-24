package gold.probelm1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[] cycleChceck;
    private static Edge[] edges;

    public static void main(String[] args) throws IOException {
        readConsole();

        int answer = calcKruskal();
        System.out.println(answer);
    }

    private static int calcKruskal() {
        int answer = 0;
        for (int i = 0; i < edges.length; i++) {
            Edge tempEdge = edges[i];
            if (cycleChceck[tempEdge.getFirstNode()-1] == cycleChceck[tempEdge.getSecondNode()-1]) continue;

            int temp = Math.max(cycleChceck[tempEdge.getFirstNode()-1], cycleChceck[tempEdge.getSecondNode()-1]);
            int next = Math.min(cycleChceck[tempEdge.getFirstNode()-1], cycleChceck[tempEdge.getSecondNode()-1]);
            cycleChceck[tempEdge.getFirstNode()-1] = cycleChceck[tempEdge.getSecondNode()-1] = next;

            for (int j = 0; j < cycleChceck.length; j++) {
                if(cycleChceck[j] == temp) {
                    cycleChceck[j] = next;
                }
            }
            answer += tempEdge.getWegiht();
            if (Arrays.stream(cycleChceck).allMatch(check -> check == 1)) break;
        }
        return answer;
    }

    private static void readConsole() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int numberOfNode = Integer.parseInt(st.nextToken());
        int numberOfEdge = Integer.parseInt(st.nextToken());
        intitVistedNodes(numberOfNode);
        initEdges(numberOfEdge);
        makeEdges(br);
    }

    private static void intitVistedNodes(int numberOfNode) {
        cycleChceck = new int[numberOfNode];
        for (int i = 0; i < numberOfNode; i++) {
            cycleChceck[i] = i+1;
        }
    }

    private static void makeEdges(BufferedReader br) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < edges.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int firstNode = Integer.parseInt(st.nextToken());
            int secondNode = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(firstNode, secondNode, weight);
        }
        Arrays.sort(edges);
    }

    private static void initEdges(int numberOfEdge) {
        edges = new Edge[numberOfEdge];
    }

    private static class Edge implements Comparable<Edge> {
        private int firstNode;
        private int secondNode;
        private int wegiht;

        public Edge(int firstNode, int secondNode, int wegiht) {
            this.firstNode = firstNode;
            this.secondNode = secondNode;
            this.wegiht = wegiht;
        }

        public int getFirstNode() {
            return firstNode;
        }

        public int getSecondNode() {
            return secondNode;
        }

        public int getWegiht() {
            return wegiht;
        }

        @Override
        public int compareTo(Edge o) {
            return this.wegiht - o.getWegiht();
        }
    }
}