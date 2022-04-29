package sliver.problem1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(calc(N));
    }

    private static int calc(int N) {

        Queue<Data> dataQueue = new LinkedList<>();
        dataQueue.add(new Data(N,0));

        while (!dataQueue.isEmpty()) {
            Data tempData = dataQueue.poll();
            if (tempData.getData() == 1) {
                return tempData.getCount();
            }

            if (tempData.getData() % 3 == 0) {
                dataQueue.add(new Data(tempData.getData() / 3, tempData.getCount() + 1));
            }
            if (tempData.getData() % 2 == 0) {
                dataQueue.add(new Data(tempData.getData() / 2, tempData.getCount() + 1));
            }
            dataQueue.add(new Data(tempData.getData()-1, tempData.getCount() + 1));
        }

        return -1;
    }

    private static class Data {
        private int data;
        private int count;

        public Data(int data, int count) {
            this.data = data;
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        public int getData() {
            return data;
        }
    }
}
