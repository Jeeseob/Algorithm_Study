package sliver.problem9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int answer;
    private static int goal;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            goal = Integer.parseInt(br.readLine());
            answer = 0;
            calcDFS(0);
            System.out.println(answer);
        }
    }

    private static void calcDFS(int tempNumber){
        if(tempNumber == goal) {
            answer++;
            return;
        }
        else if(tempNumber > goal) {
            return;
        }

        calcDFS(tempNumber + 1);
        calcDFS(tempNumber + 2);
        calcDFS(tempNumber + 3);
    }
}
