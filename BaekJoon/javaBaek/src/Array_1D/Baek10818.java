package Array_1D;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Baek10818 {
    public static void main(String[] args) {
        String string;
        String[] stringList;
        int num;
        ArrayList<Integer> numArrayList = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);

        string = scanner.nextLine();
        string = scanner.nextLine();

        stringList = string.split(" ");

        for( String str : stringList) {
            numArrayList.add(Integer.parseInt(str));
        }

        System.out.println(Collections.min(numArrayList) + " " + Collections.max(numArrayList) );

    }
}