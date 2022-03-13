package gold.problem1504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // 1에서 마지막 노드까지, 반드시 거쳐야하는 노드 2개를 거쳤을 때, 최소 거리.
    // 거쳐가는 노드를 생각해야함.
    // 양방향 그래프

    private static ArrayList<Node>[] edges;
    private static int numberOfNode;
    private static int numberOfEdge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 노드 갯수, 간선 갯수
        numberOfNode = Integer.parseInt(st.nextToken());
        numberOfEdge = Integer.parseInt(st.nextToken());

        edges = new ArrayList[numberOfNode+1];
        for (int i = 1; i < numberOfNode+1; i++) {
            edges[i] = new ArrayList<>();
        }

        // 시작노드, 도착노드, 간선거리
        for (int i = 1; i < numberOfEdge+1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int firstNode = Integer.parseInt(st.nextToken());
            int secondNode = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            // 양방향 간선
            edges[firstNode].add(new Node(secondNode, distance));
            edges[secondNode].add(new Node(firstNode, distance));
        }

        // 반드시 거쳐야하는 노드 2개
        st = new StringTokenizer(br.readLine(), " ");
        int[] necessaryNode = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        // 다익스트라 알고리즘을 활용하여, 2개의 필수노드까지의 최단 거리를 구한다.
        int[] tempAsnwers = searchNode(1);

        // 그래프가 끊겨있는 경우, -1 출력
        if(tempAsnwers[necessaryNode[0]-1] == Integer.MAX_VALUE || tempAsnwers[necessaryNode[1]-1] == Integer.MAX_VALUE || tempAsnwers[numberOfNode-1] == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        // 두가지 경우의 수를 기반으로 정답을 찾아낸다.
        int firstAnswer = findAnswer(necessaryNode[0], necessaryNode[1], tempAsnwers[necessaryNode[0]-1]);
        int secondAnswer = findAnswer(necessaryNode[1], necessaryNode[0], tempAsnwers[necessaryNode[1]-1]);

        // 두번째 노드를 기준으로 목표노드까지의 거리를 구한다.
        System.out.println(Math.min(firstAnswer, secondAnswer));
    }

    private static int findAnswer(int firstNode, int secondNode, int answer) {
        int[] tempAsnwers;
        tempAsnwers = searchNode(firstNode);
        answer += tempAsnwers[secondNode-1];
        tempAsnwers = searchNode(secondNode);

        return answer + tempAsnwers[numberOfNode - 1];
    }

    private static int[] searchNode(int startNode) {
        Boolean[] visited = new Boolean[numberOfNode];
        Arrays.fill(visited, false);

        int[] answers = new int[numberOfNode];
        Arrays.fill(answers, Integer.MAX_VALUE);

        PriorityQueue<Node> nodePriorityQueue = new PriorityQueue<>();
        nodePriorityQueue.add(new Node(startNode, 0));

        while (!nodePriorityQueue.isEmpty()) {
            Node tempNode = nodePriorityQueue.poll();
            // 방문한 적 있는 노드는 처리 X
            if (visited[tempNode.getNode() - 1]) continue;
            visited[tempNode.getNode() - 1] = true;

            for(Node nextNode : edges[tempNode.getNode()]) {
                if(answers[nextNode.getNode()-1] > tempNode.getDistance() + nextNode.getDistance()) {
                    answers[nextNode.getNode()-1] = tempNode.getDistance() + nextNode.getDistance();
                    nodePriorityQueue.add(new Node(nextNode.getNode(), answers[nextNode.getNode() - 1]));
                }
            }
        }
        answers[startNode-1] = 0;
        return answers;
    }
}

class Node implements Comparable<Node> {
    private int node;
    private int distance;

    public Node(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    public int getNode() {
        return node;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Node node) {
        return distance - node.getDistance();
    }
}
