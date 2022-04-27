package gold.problem1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int[] bagWeights;
    private static Jewlry[] jewlries;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int numberOfJewelry = Integer.parseInt(st.nextToken());
        int numberOfBag = Integer.parseInt(st.nextToken());

        getJewlries(br, numberOfJewelry);
        getBagsWeight(br, numberOfBag);

        long answer = calc();
        System.out.println(answer);
    }

    private static long calc() {
        long answer = 0;
        int tempIndex = 0;

        PriorityQueue<Integer> valueQueue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int i = 0; i < bagWeights.length; i++) {
            for (;tempIndex < jewlries.length; tempIndex++) {
                if(bagWeights[i] >= jewlries[tempIndex].getWeight()) {
                    valueQueue.add(jewlries[tempIndex].getValue());
                }
                else {
                    break;
                }
            }
            if (!valueQueue.isEmpty()) {
                answer += valueQueue.poll();
            }
        }

        return answer;
    }

    private static void getJewlries(BufferedReader br, int numberOfJewelry) throws IOException {
        StringTokenizer st;
        jewlries = new Jewlry[numberOfJewelry];

        for (int i = 0; i < numberOfJewelry; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewlries[i] = new Jewlry(weight, value);
        }
        Arrays.sort(jewlries);
    }

    private static void getBagsWeight(BufferedReader br, int numberOfBag) throws IOException {
        bagWeights = new int[numberOfBag];

        for(int i = 0; i < numberOfBag; i++) {
            bagWeights[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bagWeights);
    }

    private static class Jewlry implements Comparable<Jewlry>{
        private int weight;
        private int value;

        public Jewlry(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        public int getWeight() {
            return weight;
        }

        public int getValue() {
            return value;
        }

        @Override
        public int compareTo(Jewlry o) {
            return this.weight - o.getWeight();
        }
    }
}