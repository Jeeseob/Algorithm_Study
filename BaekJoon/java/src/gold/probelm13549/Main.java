package gold.probelm13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static int K;

    public static void main(String[] args) throws IOException {
        readConsole();
        if (check()) return;
        int answer = calc();
        System.out.println(answer);
    }


    // 0-1 너비우선 탐색 사용(dequeue를 사용하여, 거리가 0인 경우를 먼저 계산하는 방식)
    public static int calc() {
        LinkedList<Integer> dequeue = new LinkedList<>(); // dequeue로 사용
        dequeue.offer(N);

        int[] visited = new int[100001];
        Arrays.fill(visited, -1);
        visited[N] = 0;

        while (!dequeue.isEmpty()) {
            int temp = dequeue.poll();

            if (temp == K) {
                return visited[K];
            }

            if (temp * 2 <= 100000 && visited[temp * 2] == -1) {
                dequeue.addFirst(temp * 2);
                visited[temp * 2] = visited[temp];
            }

            if (temp > 0 && visited[temp - 1] == -1) {
                dequeue.offer(temp - 1);
                visited[temp - 1] = visited[temp] + 1;
            }

            if (temp < 100000 && visited[temp + 1] == -1) {
                dequeue.offer(temp + 1);
                visited[temp + 1] = visited[temp] + 1;
            }
        }
        return -1;
    }

    private static boolean check() {
        if(K < N) {
            System.out.println(N-K);
            return true;
        }
        return false;
    }

    private static void readConsole() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }
}
