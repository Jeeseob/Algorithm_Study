package gold.problem1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
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
}

public class Main {

    // 문제에서 잘못 생각했던 부분 : 중간에 끊기는 부분에 대한 생각을 함...

    // But, 트리는 모든 노드가 연결되어 있다!!
    // --> 하나의 노드를 기준으로 가장 먼 노드를 찾고, 해당 노드에서 가장 먼 노드를 찾으면 두 노드의 거리가 지름이다.
    private static ArrayList<int[]>[] nodeData; // 노드간의 연결(입력 데이터) 저장
    private static int numberOfNode = 0;

    // answer
    private static int maxDistance = 0;
    private static int maxDistanceNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 전체 노드의 갯수
        numberOfNode = Integer.parseInt(st.nextToken());
        nodeData = new ArrayList[numberOfNode + 1];
        for (int i = 1; i < numberOfNode + 1; i++) {
            nodeData[i] = new ArrayList<>();
        }

        for (int i = 1; i < numberOfNode + 1; i++) {
            // 첫번째 값은 노드의 값.
            st = new StringTokenizer(br.readLine(), " ");
            int tempNode = Integer.parseInt(st.nextToken());

            while (true) {
                int sNode = Integer.parseInt(st.nextToken());
                // 2개씩 끊어서 입력받고, -1인 경우, 끝을 의미
                if (sNode == -1) {
                    break;
                }
                int eNode = Integer.parseInt(st.nextToken());
                nodeData[tempNode].add(new int[]{sNode, eNode});
            }
        }
        // 임의의 노드에서 가장 먼 노드 찾기
        searchTree(1);
        // 가장 먼 노드와 가장 먼 노드를 찾고, 그 거리를 구한다.
        searchTree(maxDistanceNode);
        System.out.println(maxDistance);
    }

    // BFS - startNode를 기준으로 가장 먼 노드와, 그 거리를 찾는 함수.
    private static void searchTree(int start) {
        //BFS를 위한 Queue
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(new Node(start, 0));

        // 무한 반복 방지를 위한 visted
        Boolean[] visited = new Boolean[numberOfNode+1];

        Arrays.fill(visited, false);
        visited[start] = true;

        maxDistance = 0;

        // BFS
        while (!nodeQueue.isEmpty()) {
            Node startNode = nodeQueue.poll();
            visited[startNode.getNode()] = true;
            for (int[] node : nodeData[startNode.getNode()]) {
                // 방문한적 없는 노드일 때만, 실행
                if (!visited[node[0]]) {
                    Node nextNode = new Node(node[0], node[1] + startNode.getDistance());
                    nodeQueue.offer(nextNode);
                    // 길이가 더 먼 node가 있다면, 갱신
                    if(maxDistance < nextNode.getDistance()) {
                        maxDistance = nextNode.getDistance();
                        maxDistanceNode = nextNode.getNode();
                    }
                }
            }
        }
    }
}