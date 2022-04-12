package gold.problem15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class House {
    private int row;
    private int column;

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public House(int row, int column) {
        this.row = row;
        this.column = column;
    }
}

public class Main {

    private static int N;
    private static int M;
    private static int[][] bruteForce;

    private static ArrayList<House> homeList;
    private static ArrayList<House> chickenList;

    private static int answer;

    public static void main(String[] args) throws IOException {
        homeList = new ArrayList<>();
        chickenList = new ArrayList<>();
        answer = Integer.MAX_VALUE;

        readConsole();

        bruteForce = new int[homeList.size()][chickenList.size()];
        makeBruteForce();

        // 치킨집 중, M개 골라서 그것들만 사용해서 계산.
        int[] answers = new int[M];
        calc(answers, 0, 0);

        System.out.println(answer);
    }

    private static void clacAnswer(int[] answers) {
        int tempAnswer = 0;
        for(int i = 0; i < homeList.size(); i++) {
            int temp = Integer.MAX_VALUE;
            for (int index : answers) {
                temp = Math.min(temp, bruteForce[i][index]);
            }
            tempAnswer += temp;
        }

        answer = Math.min(tempAnswer, answer);
    }

    private static void calc(int[] answers, int lastIndex, int tempIndex) {
        if (tempIndex == M) {
            clacAnswer(answers);
            return;
        }
        for (int i = lastIndex; i < chickenList.size(); i++) {
            answers[tempIndex] = i;
            calc(answers, i, tempIndex + 1);
        }
    }

    private static void makeBruteForce() {
        for (int i = 0; i < homeList.size(); i++) {
            for (int j = 0; j < chickenList.size(); j++) {
                House tempHome = homeList.get(i);
                House tempChicken = chickenList.get(j);
                bruteForce[i][j] = Math.abs(tempHome.getRow() - tempChicken.getRow()) + Math.abs(tempHome.getColumn() - tempChicken.getColumn());
            }
        }
    }

    private static void readConsole() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1) {
                    homeList.add(new House(i, j));
                }
                if (temp == 2) {
                    chickenList.add(new House(i, j));
                }
            }
        }
    }
}
