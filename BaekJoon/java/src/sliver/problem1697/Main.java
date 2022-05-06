package sliver.problem1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int answer = calcAnswer(start, target);
        System.out.println(answer);
    }

    private static int calcAnswer(int start, int target) {
        int answer = 0;
        int big = start > target ? start : target;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        Boolean[] visited = new Boolean[big*2+1];
        Arrays.fill(visited, false);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            int tempPoint = temp.getPoint();
            int tempSecond = temp.getSecond();

            if(visited[tempPoint]) continue;
            visited[tempPoint] = true;

            if(temp.getPoint() == target) {
                answer = temp.getSecond();
                break;
            }

            if(tempPoint * 2 <= big * 2) {
                queue.add(new Node(tempPoint * 2, tempSecond + 1));
            }
            if(tempPoint + 1 <= big * 2) {
                queue.add(new Node(tempPoint + 1, tempSecond + 1));
            }
            if(0<= tempPoint - 1 && tempPoint - 1 <= big * 2) {
                queue.add(new Node(tempPoint - 1, tempSecond + 1));
            }
        }
        return answer;
    }


    private static class Node implements Comparable<Node>{
        private int point;
        private int second;

        public Node(int point, int second) {
            this.point = point;
            this.second = second;
        }

        public int getPoint() {
            return point;
        }

        public int getSecond() {
            return second;
        }

        @Override
        public int compareTo(Node o) {
            return this.second - o.getSecond();
        }
    }
}
