package sliver.problem2407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        System.out.println(combination(n, m));
    }

    private static BigInteger combination(int n, int m) {
        // 불필요한 연산을 줄일 수 있다.
        if(m < n/2) {
            m = n-m;
        }
        return permutation(n, m + 1).divide(permutation(n - m, 1));
    }

    // BigInteger -> bit 제한이 없다.
    private static BigInteger permutation(int start, int end) {
        BigInteger temp = BigInteger.ONE;
        for(int i = start; i >= end; i--) {
            temp = temp.multiply(new BigInteger(String.valueOf(i)));
        }
        return temp;
    }
}
