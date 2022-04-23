package gold.problem1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int numberOfBuilding;
    private static int numberOfRule;
    private static int goal;

    private static int[] buildTimes;
    private static ArrayList<Integer>[] beforeBuilding;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCase = Integer.parseInt(br.readLine());

        StringBuilder stringBuilder = new StringBuilder();
        for(int j = 0; j < numberOfTestCase; j++) {
            readConsole(br);
            int answer = calcACM();
            stringBuilder.append(answer + "\n");
        }
        System.out.println(stringBuilder);
    }

    private static int calcACM() {
        // 목표 부터 역순으로 시작한다.
        // DP + BFS 이용해, 값을 구한다.
        Queue<Integer> buildingQueue = new LinkedList<>();
        buildingQueue.add(goal);

        int[] dynamicArray = new int[numberOfBuilding + 1];
        Boolean[] visited = new Boolean[numberOfBuilding + 1];
        Arrays.fill(visited, false);

        dynamicArray[goal] = buildTimes[goal];

        while (!buildingQueue.isEmpty()) {
            int before = buildingQueue.poll();
            visited[before] = true;

            for (int next : beforeBuilding[before]) {
                if(!visited[next] || dynamicArray[next] < (buildTimes[next] + dynamicArray[before]) ) {
                    buildingQueue.add(next);
                }
                dynamicArray[next] = Math.max(dynamicArray[next], buildTimes[next] + dynamicArray[before]);
            }
        }

        return Arrays.stream(dynamicArray).max().orElse(-1);
    }

    private static void readConsole(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        numberOfBuilding = Integer.parseInt(st.nextToken());
        numberOfRule = Integer.parseInt(st.nextToken());

        getBuildTimes(br);

        initBeforeBuilding();
        getBeforeBuilding(br);

        goal = Integer.parseInt(br.readLine());
    }

    private static void getBeforeBuilding(BufferedReader br) throws IOException {
        for (int i = 0; i < numberOfRule; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int before = Integer.parseInt(st.nextToken()); // 이전 빌딩
            int next = Integer.parseInt(st.nextToken()); // 다음 빌딩
            beforeBuilding[next].add(before);
        }
    }

    private static void getBuildTimes(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        buildTimes = new int[numberOfBuilding+1];
        for (int i = 1; i <= numberOfBuilding; i++) {
            buildTimes[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void initBeforeBuilding() {
        beforeBuilding = new ArrayList[numberOfBuilding+1];
        for (int i =1; i <= numberOfBuilding; i++) {
            beforeBuilding[i] = new ArrayList<>();
        }
    }
}
