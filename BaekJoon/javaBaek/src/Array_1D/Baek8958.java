package Array_1D;

import java.util.ArrayList;
import java.util.Scanner;

public class Baek8958 {

    public static void main(String[] args) {
        int count;
        int addPoint;
        int point;
        String test;
        String[] testResults;
        Scanner scanner = new Scanner(System.in);

        count = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i<count; i++ ) {
            point = 0;
            addPoint = 1;
            test = scanner.nextLine();
            testResults = test.split("");

            for(String str : testResults) {
                //System.out.println(str);
                if(str.equals("O")) {
                    point += addPoint;
                    addPoint +=1;
                }
                else {
                    addPoint = 1;
                }
            }

            System.out.println(point);
        }
    }
}
