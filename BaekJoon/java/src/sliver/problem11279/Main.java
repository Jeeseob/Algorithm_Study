package sliver.problem11279;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (temp == 0) {
                if (priorityQueue.isEmpty()) {
                    bw.write("0\n");
                }
                else {
                    bw.write(priorityQueue.poll() + "\n");
                }
            }
            else {
                priorityQueue.offer( temp);
            }
        }
        bw.flush();
        bw.close();
    }
}
