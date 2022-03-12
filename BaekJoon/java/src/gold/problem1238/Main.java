package gold.problem1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


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

    // 우선순위 큐를 사용하기 위한, compareTo overriding
    @Override
    public int compareTo(Node node) {
        return distance - node.getDistance();
    }
}


public class Main {

    private static int numberOfNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        numberOfNode = Integer.parseInt(st.nextToken());
        int numberOfEdge = Integer.parseInt(st.nextToken());
        int townToParty = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] nodeArrayLists = new ArrayList[numberOfNode+1]; // edge 데이터 저장

        // 이게 포인트!!! 물론 단순 반복을 돌려서 파티장까지의 거리를 구해도 되지만, 그것보단. 이렇게 하는게 시간적으로 좋다.
        ArrayList<Node>[] reverseNodeArrayLists = new ArrayList[numberOfNode + 1]; // edge데이터를 반대로 저장

        for(int i = 1; i< numberOfNode+1; i++) {
            nodeArrayLists[i] = new ArrayList<>();
            reverseNodeArrayLists[i] = new ArrayList<>();
        }

        for(int i = 0; i < numberOfEdge; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int tempNode = Integer.parseInt(st.nextToken());
            int nextNode = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            nodeArrayLists[tempNode].add(new Node(nextNode, distance));
            reverseNodeArrayLists[nextNode].add(new Node(tempNode, distance));
        }

        // 파티장까지 가는 거리
        int[] answersToParty = searchTown(townToParty, reverseNodeArrayLists);
        // 파티장에서 집까지 가는 거리
        int[] answersToHome = searchTown(townToParty, nodeArrayLists);

        int answer = 0;
        for (int i = 0; i < numberOfNode; i++) {
            answer = Math.max(answer, answersToHome[i] + answersToParty[i]);
        }

        System.out.println(answer);
    }

    // 다익스트라 알고리즘 활용
    private static int[] searchTown(int startNode, ArrayList<Node>[] nodeArrayLists) {
        int[] answers = new int[numberOfNode]; // startNode 부터, 각 노드까지의 거리
        Arrays.fill(answers, Integer.MAX_VALUE);
        answers[startNode-1] = 0;

        Boolean[] visited = new Boolean[numberOfNode];
        Arrays.fill(visited, false);

        PriorityQueue<Node> nodeQueue = new PriorityQueue<>();
        nodeQueue.add(new Node(startNode, 0));

        while (!nodeQueue.isEmpty()) {
            Node tempNode = nodeQueue.poll();
            if(visited[tempNode.getNode()-1]) continue;

            visited[tempNode.getNode()-1] = true;
            for(Node edgeData : nodeArrayLists[tempNode.getNode()]) {
                if (answers[edgeData.getNode()-1] > answers[tempNode.getNode()-1] + edgeData.getDistance()) {
                    answers[edgeData.getNode()-1] = answers[tempNode.getNode()-1] + edgeData.getDistance();

                    // nodeQueue.add(new Node(edgeData.getNode(), edgeData.getDistance()));
                    // 위에걸 아래걸로 바꾸니까 성공했다... 뭐지??
                    nodeQueue.add(new Node(edgeData.getNode(), answers[edgeData.getNode() - 1]));
                }
            }
        }
        return answers;
    }
}

