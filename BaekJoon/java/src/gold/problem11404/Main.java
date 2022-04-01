package gold.problem11404;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int numberOfCity;
    private static int numberOfBus;
    private static final int INF = 9999999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numberOfCity = Integer.parseInt(br.readLine());
        numberOfBus = Integer.parseInt(br.readLine());

        int[][] answers = readBusRoute(br);
        calcBusPrice(answers);
        printAnswers(answers);
    }

    // 플로이드 와샬 알고리즘 (모든 노드에서 모든 노드로 가는 가장 짧은 거리)
    private static void calcBusPrice(int[][] answers) {
        for (int k = 0; k < numberOfCity; k++) {
            for (int i = 0; i < numberOfCity; i++) {
                for (int j = 0; j < numberOfCity; j++) {
                    if(k == i) break;
                    if(i == j || k == j) continue;
                    answers[i][j] = Math.min(answers[i][j], answers[i][k] + answers[k][j]);
                }
            }
        }
    }


    private static int[][] readBusRoute(BufferedReader br) throws IOException {
        int[][] answers = makeAnswers();
        for (int i = 0; i < numberOfBus; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int end = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int price = Integer.parseInt(stringTokenizer.nextToken());

            // 같은 노선이 있다면, 가장 적은 비용의 노선만 입력 받는다. -> 이걸 못봐서 계속 틀렸음..
            answers[start][end] = Math.min(price, answers[start][end]);
        }
        return answers;
    }

    // answers 초기 세팅
    private static int[][] makeAnswers() {
        int[][] answers = new int[numberOfCity][numberOfCity];

        for (int i = 0; i < numberOfCity; i++) {
            for (int j = 0; j < numberOfCity; j++) {
                if(i==j) {
                    answers[i][j] = 0;
                }
                else {
                    answers[i][j] = INF;
                }
            }
        }
        return answers;
    }

    // 출력
    private static void printAnswers(int[][] answers) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < answers[0].length; j++) {
                if(answers[i][j] == INF) {
                    stringBuilder.append(0);
                    stringBuilder.append(' ');
                    continue;
                }
                stringBuilder.append(answers[i][j]);
                stringBuilder.append(' ');
            }
            if(i == answers.length-1) continue;
            stringBuilder.append('\n');
        }
        System.out.println(stringBuilder);
    }
}
