package gold.problem13172;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    private static final long mod = 1000000007;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfDice = Integer.parseInt(br.readLine());
        long answer = 0;

        for(int i = 0; i < numberOfDice; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            BigInteger N = getBigInteger(st);
            BigInteger S = getBigInteger(st);

            BigInteger gcd = N.gcd(S);

            long longN = N.longValue() / gcd.longValue();
            long longS = S.longValue()/ gcd.longValue();

            answer += calc(longS, longN);
            answer %= mod;
        }
        System.out.println(answer);
    }

    private static BigInteger getBigInteger(StringTokenizer st) {
        return BigInteger.valueOf(Long.valueOf(st.nextToken()));
    }

    private static Long calc(long S, long N) {
        long temp = S * pow(N, mod - 2) % mod;
        return temp % mod;
    }

    public static long pow(long N, long tempMod) {
        if(tempMod == 1) {
            return N % mod;
        }

        long temp = pow(N, tempMod / 2);

        // 홀수인 경우,
        if(tempMod % 2 == 1) {
            return (temp * temp % mod) * N % mod;
        }

        return temp * temp % mod;
    }
}