package sliver.problem1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());


        StringBuilder stringBuilder = new StringBuilder();

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());

            if(temp == 0) {
                if (priorityQueue.isEmpty()) {
                    stringBuilder.append(0 + "\n");
                }
                else {
                    stringBuilder.append(  priorityQueue.poll() + "\n");
                }
            }
            else {
                priorityQueue.add(temp);
            }
        }

        System.out.println(stringBuilder);
    }
}
