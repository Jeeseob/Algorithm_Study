package sliver.problem1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());

        int length = (int) Math.pow(2, N); //한 변의 사이즈

        calcAnswer(length, row, column);
        System.out.println(answer);
    }

    private static void calcAnswer(int tempLength, int row, int column) {
        if(tempLength == 1)
            return;

        if(row < tempLength/2 && column < tempLength/2) {
            calcAnswer(tempLength/2, row, column);
        }

        else if(row < tempLength/2 && column >= tempLength/2) {
            answer += tempLength * tempLength / 4;
            calcAnswer(tempLength/2, row, column - tempLength/2);
        }

        else if(row >= tempLength/2 && column < tempLength/2) {
            answer += (tempLength * tempLength / 4) * 2;
            calcAnswer(tempLength/2, row - tempLength/2, column);
        }

        else {
            answer += (tempLength * tempLength / 4) * 3;
            calcAnswer(tempLength/2, row - tempLength/2, column - tempLength/2);
        }
    }
}
