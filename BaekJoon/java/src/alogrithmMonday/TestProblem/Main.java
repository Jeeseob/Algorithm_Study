package alogrithmMonday.TestProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * @Author : Jeeseob
 * @CreateAt : 2022/07/06
 */

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long num = Long.parseLong(br.readLine());

        if (num == 1) {
            System.out.println("Yes");
        }
        else {
            while (num > 1) {
                if (num % 2 != 0) {
                    System.out.println("No");
                    break;
                }
                num = num / 2;
            }
            if(num <= 1) {
                System.out.println("Yes");
            }
        }
    }
}
