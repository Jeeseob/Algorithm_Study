package bronze.problem2675;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int reptition = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < reptition; i++) {
            String[] repititionPrint = scanner.nextLine().split(" ");
            int rep = Integer.parseInt(repititionPrint[0]);
            String[] strings = repititionPrint[1].split("");

            String data = "";
            for (String string : strings) {
                for (int j = 0; j < rep; j++) {
                    data+=string;
                }
            }
            System.out.println(data);
        }
    }
}
