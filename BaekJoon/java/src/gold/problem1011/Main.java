package gold.problem1011;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int answer ;
        Scanner scanner = new Scanner(System.in);
        int repititionNumber = scanner.nextInt();


        for(int i = 0; i < repititionNumber; i++) {
            int distanceTraveled = 0;
            int count = 0;

            int distance = ( scanner.nextInt() * (-1) ) + scanner.nextInt();

            // 횟수별로, 가능한 최고 값이 정해져 있다.
            while (distance/2 + distance%2 > distanceTraveled) {
                count++;
                distanceTraveled += count;
            }

            answer = (2 * count) - 1;

            // if(distanceTraveled * 2 - count < distance)
            // 위의 방법으로 하면, distance가 2^31 즉 int로 표현 가능한 최대 값일 때, 오버플로우가 나서, 정확한 비교가 안된다...

            if(distanceTraveled < (distance + count) / 2 + (distance + count) % 2) {
                answer += 1;
            }
            System.out.println(answer);
        }
    }
}

