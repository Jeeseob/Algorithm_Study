package gold.problem12851;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int K;

    public static void main(String[] args) throws IOException {
        readConsole();
        if (N >= K) {
            print(N-K, 1);
            return;
        }

        int[] answer = calc();
        print(answer[0], answer[1]);
        return;
    }

    private static void print(int i, int i2) {
        System.out.println(i);
        System.out.println(i2);
    }

    private static int[] calc() {
        int[] answer = new int[2]; // 0 : 최소 경로 / 1 : 경우의 수
        answer[0] = Integer.MAX_VALUE;

        Queue<Integer> nodeQueue = new LinkedList<>();
        nodeQueue.add(N);

        int[] visted = new int[100001];
        visted[N] = 1;

        while (!nodeQueue.isEmpty()) {
            Integer temp = nodeQueue.poll();

            // DFS가 아니라 BFS로 해결하는 이유 : 최소 경로를 구하는 것이기 때문에, 그 이상 아래의 node로 내려가지 않도록 한다.
            if (visted[temp] > answer[0]) {
                return answer;
            }


            int next;
            for (int i = 0; i < 3; i++) {
                if(i == 0) {
                    next = temp + 1;
                } else if(i == 1) {
                    next = temp * 2;
                } else {
                    next = temp -1;
                }

                if (next < 0 || next > 100000) continue;

                if (next == K) {
                    answer[0] = visted[temp];
                    answer[1] += 1;
                }
                if (visted[next] == 0 || visted[next] == visted[temp] + 1) {
                    nodeQueue.add(next);
                    visted[next] = visted[temp] + 1;
                }
            }
        }
        return answer;
    }


    private static void readConsole() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        br.close();
    }
}