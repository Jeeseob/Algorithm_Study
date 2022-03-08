package sliver.problem1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 타입을 신경쓰자.
    // 최대 처리가능한 변수를 파악하고, 이에 맞는 타입을 적용하자.
    // 수학적으로 규칙이 존재하는 문제는 규칙을 기반으로 연산량을 줄일 수 있다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long A= Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());


        System.out.println(pow(A,B,C));
    }

    public static long pow(long A, long tempB, long C) {
        if(tempB == 1) {
            return A % C;
        }

        long temp = pow(A, tempB / 2, C);

        // B가 홀수인 경우,
        if(tempB % 2 == 1) {
            return (temp * temp % C) * A % C;
        }

        return temp * temp % C;

    }
}
