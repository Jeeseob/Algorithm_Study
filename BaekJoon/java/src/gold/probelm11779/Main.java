package gold.probelm11779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Bus implements Comparable<Bus>  {
    private int nextCity;
    private int price;

    public Bus(int nextCity, int price) {
        this.nextCity = nextCity;
        this.price = price;
    }

    public int getNextCity() {
        return nextCity;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int compareTo(Bus o) {
        return price - o.getPrice();
    }
}

public class Main {
    private static int numberOfCity;
    private static int numberOfBus;

    private static int startCity;
    private static int endCity;

    private static int[] answers;
    private static int[] beforeCity;
    private static ArrayList<Integer> answerCitys;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numberOfCity = Integer.parseInt(br.readLine());
        numberOfBus = Integer.parseInt(br.readLine());

        ArrayList<Bus>[] busArrayList = makeGraph(numberOfCity);
        readGraphData(br, busArrayList);
        br.close();

        dijkstra(busArrayList);

        print();
    }

    private static void print() {
        StringBuilder stringBuilder = new StringBuilder();
        answerCitys = new ArrayList<>();

        int numberOfBeforeCity = findBeforeCity(beforeCity);
        stringBuilder.append(answers[endCity]+"\n");
        stringBuilder.append(numberOfBeforeCity + "\n");

        for(int i = answerCitys.size()-1; i >= 0; i--) {
            stringBuilder.append(answerCitys.get(i) + " ");
        }
        System.out.print(stringBuilder);
    }

    // 이전 노드를 기반으로 첫번째 노드까지 가는 노드들을 찾아냄
    private static int findBeforeCity(int[] beforeCity) {
        int temp = endCity;
        while(true) {
            answerCitys.add(temp);
            if (temp == startCity) {
                break;
            }
            temp = beforeCity[temp];
        }
        return answerCitys.size();
    }

    private static void dijkstra(ArrayList<Bus>[] busArrayList) {
        PriorityQueue<Bus> busPriorityQueue = new PriorityQueue<>();
        busPriorityQueue.add(new Bus(startCity, 0));

        Boolean[] visited = new Boolean[numberOfCity+1];
        Arrays.fill(visited, false);

        answers = new int[numberOfCity+1];
        Arrays.fill(answers,1000000001);
        answers[startCity] = 0;

        beforeCity = new int[numberOfCity+1];
        beforeCity[startCity] = 0;

        while(!busPriorityQueue.isEmpty()) {
            Bus tempBus = busPriorityQueue.poll();
            if(visited[tempBus.getNextCity()]) continue;
            visited[tempBus.getNextCity()] = true;

            for (Bus nextBus : busArrayList[tempBus.getNextCity()]) {
                if(answers[nextBus.getNextCity()] > nextBus.getPrice() + answers[tempBus.getNextCity()]){
                    answers[nextBus.getNextCity()] = nextBus.getPrice() +  answers[tempBus.getNextCity()];
                    // 이전 노드를 저장
                    beforeCity[nextBus.getNextCity()] = tempBus.getNextCity();
                    busPriorityQueue.add(new Bus(nextBus.getNextCity(), answers[nextBus.getNextCity()]));
                }
            }
        }
    }

    private static void readGraphData(BufferedReader br, ArrayList<Bus>[] busArrayList) throws IOException {
        StringTokenizer stringTokenizer;
        for (int i = 0; i < numberOfBus; i++) {
            stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int tempCity = Integer.parseInt(stringTokenizer.nextToken());
            int nextCity = Integer.parseInt(stringTokenizer.nextToken());
            int price = Integer.parseInt(stringTokenizer.nextToken());

            busArrayList[tempCity].add(new Bus(nextCity, price));
        }
        stringTokenizer = new StringTokenizer(br.readLine(), " ");

        startCity = Integer.parseInt(stringTokenizer.nextToken());
        endCity = Integer.parseInt(stringTokenizer.nextToken());
    }

    private static ArrayList[] makeGraph(int numberOfCity) {
        ArrayList<Bus>[] busArrayList = new ArrayList[numberOfCity+1];
        for (int i = 1; i <= numberOfCity; i++) {
            busArrayList[i] = new ArrayList<>();
        }
        return busArrayList;
    }
}
