package gold.problem7579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int needMemory;
    private static int maxCost;
    private static int[] dynamicArray;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int numberOfApp = Integer.parseInt(st.nextToken());
        needMemory = Integer.parseInt(st.nextToken());

        Node[] apps = new Node[numberOfApp];
        getMemorys(br, apps);
        getCosts(br, apps);

        getDynamicArray();
        clacDynamicArray(apps);

        print();


    }

    private static void clacDynamicArray(Node[] apps) {
        for (int i = 0; i < apps.length; i++) {
            int tempCost = apps[i].getCost();
            int tempMemory = apps[i].getMemory();
            for (int j = maxCost; j >= tempCost; j--) {
                if (dynamicArray[j - tempCost] != -1) {
                    if (dynamicArray[j - tempCost] + tempMemory > dynamicArray[j]) {
                        dynamicArray[j] = dynamicArray[j-tempCost] + tempMemory;
                    }
                }
            }
            if(dynamicArray[tempCost] < tempMemory) {
                dynamicArray[tempCost] = tempMemory;
            }
        }
    }

    private static void getDynamicArray() {
        dynamicArray = new int[maxCost+1];
        Arrays.fill(dynamicArray, -1);
    }

    private static void getMemorys(BufferedReader br, Node[] apps) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < apps.length; i++) {
            apps[i] = new Node(Integer.parseInt(st.nextToken()));
        }
    }

    private static void getCosts(BufferedReader br, Node[] apps) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i <  apps.length; i++) {
            apps[i].setCost(Integer.parseInt(st.nextToken()));
            maxCost += apps[i].getCost();
        }
    }

    private static void print() {
        for (int i = 0; i < dynamicArray.length; i++) {
            if (dynamicArray[i] >= needMemory) {
                System.out.println(i);
                break;
            }
        }
    }

    private static class Node {
        private int memory;
        private int cost;

        public Node(int memory) {
            this.memory = memory;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public int getMemory() {
            return memory;
        }

        public int getCost() {
            return cost;
        }
    }
}
