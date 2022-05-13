package sliver.problem2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static Boolean[] visited;
    private static int numberOfNode;
    private static int numberOfEdge;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numberOfNode = Integer.parseInt(br.readLine());
        numberOfEdge = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] network = initNetwork();
        getNetwork(br, network);

        calcBFS(network);

        int answer = getAnswer();
        System.out.println(answer-1);

    }

    private static void calcBFS(ArrayList<Integer>[] network) {
        visited = new Boolean[numberOfNode+1];
        Arrays.fill(visited, false);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if(visited[temp]) continue;

            visited[temp] = true;
            for (int i = 0; i < network[temp].size(); i++) {
                queue.add(network[temp].get(i));
            }
        }
    }

    private static int getAnswer() {
        int answer = 0;
        for (int i = 1; i <= numberOfNode; i++) {
            if(visited[i]) {
                answer++;
            }
        }
        return answer;
    }

    private static ArrayList[] initNetwork() {
        ArrayList[] network = new ArrayList[numberOfNode +1];
        for (int i = 1; i <= numberOfNode; i++) {
            network[i] = new ArrayList<>();
        }
        return network;
    }

    private static void getNetwork(BufferedReader br, ArrayList[] network) throws IOException {
        for (int i = 0; i < numberOfEdge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            network[node1].add(node2);
            network[node2].add(node1);
        }
    }
}
