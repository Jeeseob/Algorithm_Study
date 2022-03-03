package gold.problem1011;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int repititionNumber = scanner.nextInt();

        for(int i = 0; i < repititionNumber; i++) {
            int answer = 0;
            int distanceTraveled = 0;
            int speed = 1;

            int distance = ( scanner.nextInt() * (-1) ) + scanner.nextInt();

            System.out.println("distance = " + distance);

            while (distance/2 > distanceTraveled) {
                distanceTraveled += speed;
                speed++;
                answer++;
            }
            System.out.println("distanceTraveled = " + distanceTraveled);
            System.out.println("answer = " + answer);
            System.out.println("speed = " + speed);

            if(distance%2 == 0) {
                if(distance/2 < distanceTraveled) {
                    answer = answer * 2 - 1;
                }
                else {
                    answer = answer * 2;
                }
            }
            else {
                if(distance/2 == distanceTraveled) {
                    answer = answer * 2 + 1;
                }
                else {
                    answer = answer * 2;
                }
            }
                System.out.println(answer);
        }
    }
}
