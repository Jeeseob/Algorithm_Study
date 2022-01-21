package Array_1D;

import java.util.ArrayList;
import java.util.Scanner;

public class Baek4344 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i<count; i++ ){
            double totalPoint = 0;
            double resultNum = 0;

            String[] strArr = scanner.nextLine().split(" ");

            int count2 = Integer.parseInt(strArr[0]);

            for(int j = 1; j<=count2; j++) {
                totalPoint += Integer.parseInt(strArr[j]);
            }
            System.out.println(totalPoint);

            double averagePoint = totalPoint/count2;

            System.out.println(averagePoint);

            for(int j = 1; j<=count2; j++) {
                if(Integer.parseInt(strArr[j]) > averagePoint) {
                    resultNum+=1;
                }
            }
            double result = resultNum/count2 * 100;
            System.out.println(String.format("%.3f",result) +"%");

        }


    }

}
