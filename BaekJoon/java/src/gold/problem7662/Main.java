package gold.problem7662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 문제를 N번 반복하여 해결
        for(int i = 0; i < N; i++) {

            // 실제 문제 시작
            int numberOfData = Integer.parseInt(br.readLine());
            DualPriorityQueue dualPriorityQueue = new DualPriorityQueue();

            for(int j = 0; j < numberOfData; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                String instruct = st.nextToken();
                int tempInstData = Integer.parseInt(st.nextToken());

                if(instruct.equals("I")) {
                    dualPriorityQueue.offer(tempInstData);
                }
                else if(instruct.equals("D")) {
                    dualPriorityQueue.poll(tempInstData);
                }
            }
            dualPriorityQueue.print();
        }
    }

    private static class DualPriorityQueue {
        private PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        private PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<>();
        private Map<Integer, Integer> dataMap = new HashMap<>();
        private final String empty = "EMPTY";

        public void print() {
            String max = this.poll(1);
            if(max.equals(empty)) {
                System.out.println(empty);
            }
            else {
                String min = this.poll(-1);
                if(min.equals(empty)) {
                    System.out.println(max + " " + max);
                }
                else {
                    System.out.println(max + " " + min);
                }
            }
        }

        public void offer(int number) {
            maxPriorityQueue.add(number);
            minPriorityQueue.add(number);
            dataMap.put(number, dataMap.getOrDefault(number, 0) + 1);
        }

        public String poll(int instruct) {
            String temp;
            if(instruct > 0) {
                temp = calcDelete(maxPriorityQueue);
            } else {
                temp = calcDelete(minPriorityQueue);
            }

            return temp;
        }

        private String calcDelete(PriorityQueue<Integer> priorityQueue) {
            while (!priorityQueue.isEmpty()) {
                int temp = priorityQueue.poll();
                // dataMap에서 value가 0인 값은 이미 Heap에서 나간 값
                int count = dataMap.getOrDefault(temp, 0);
                if (count > 0) {
                    dataMap.replace(temp, count - 1);
                    return Integer.toString(temp);
                }
            }
            return empty;
        }
    }
}
