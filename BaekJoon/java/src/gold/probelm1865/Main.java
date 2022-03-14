package gold.probelm1865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static ArrayList<Edge>[] edgeDatas;
    private static int numberOfNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int numberOfTestCase = Integer.parseInt(st.nextToken());

        for(int i = 0; i < numberOfTestCase; i++) {
            // 노드의 수, 도로의 수, 웜홀의 수...
            st = new StringTokenizer(br.readLine(), " ");

            numberOfNode = Integer.parseInt(st.nextToken());
            int numberOfPlusEdge = Integer.parseInt(st.nextToken());
            int numberOfMinusEdge = Integer.parseInt(st.nextToken());

            // Edge 정보 저장.
            edgeDatas = new ArrayList[numberOfNode + 1];

            // init ArrayList[]
            for (int j = 1; j <= numberOfNode; j++) {
                edgeDatas[j] = new ArrayList<>();
            }

            int startNode;
            int endNode;
            int time;

            // 도로의 수 만큼, 시작 노드, 도착노드, 시간(+);
            for (int j = 0; j < numberOfPlusEdge; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                startNode = Integer.parseInt(st.nextToken());
                endNode = Integer.parseInt(st.nextToken());
                time = Integer.parseInt(st.nextToken());

                edgeDatas[startNode].add(new Edge(endNode, time));
                edgeDatas[endNode].add(new Edge(startNode, time));
            }

            // 웜홀의 수 만큼, 시작노드, 도착노드, 시간(-);
            for (int j = 0; j < numberOfMinusEdge; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                startNode = Integer.parseInt(st.nextToken());
                endNode = Integer.parseInt(st.nextToken());
                time = Integer.parseInt(st.nextToken());

                edgeDatas[startNode].add(new Edge(endNode, time*(-1)));
            }


            // 벨만-포드 알고리즘를 반복한다.
            Boolean tempAnsesr = false;
            for (int j = 1; j <= numberOfNode; j++) {
                if(searchWorld(j)) {
                    System.out.println("YES");
                    tempAnsesr = true;
                    break;
                }
            }
            if (!tempAnsesr) {
                System.out.println("NO");
            }
        }
    }

    // 벨만-포드 알고리즘의 변형, 시작 Node까지의 도달가능한 값이 -인 경우 : true
    private static Boolean searchWorld(int startNode) {
        int[] tempAnswer = new int[numberOfNode];
        Arrays.fill(tempAnswer, Integer.MAX_VALUE-100000);
        tempAnswer[startNode-1] = 0;

        Boolean update = false;

        for(int i = 1; i < numberOfNode; i++){
            update = false;
            // tempNode와 연결된 모든 node의 값 갱신
            for(int tempNode = 1; tempNode <= numberOfNode; tempNode ++) {
                for (Edge nextEdge : edgeDatas[tempNode]) {
                    if (tempAnswer[tempNode - 1] != Integer.MAX_VALUE-100000 && tempAnswer[nextEdge.getNode() - 1] > tempAnswer[tempNode - 1] + nextEdge.getTime()) {
                        tempAnswer[nextEdge.getNode() - 1] = tempAnswer[tempNode - 1] + nextEdge.getTime();
                        update = true;
                    }
                }
            }
            if(!update) {
                break;
            }
        }

        // 음수 cycle 체크
        if (update) {
            for (int i = 1; i <= numberOfNode; i++) {
                for (Edge nextEdge : edgeDatas[i]) {
                    if (tempAnswer[i-1] != Integer.MAX_VALUE-100000 && tempAnswer[nextEdge.getNode() - 1] > tempAnswer[i-1] + nextEdge.getTime()) {
                        return true;
                    }
                }
            }
        }
        return false;

    }
}

class Edge {
    private int node;
    private int time;

    public Edge(int node, int time) {
        this.node = node;
        this.time = time;
    }

    public int getNode() {
        return node;
    }

    public int getTime() {
        return time;
    }
}
