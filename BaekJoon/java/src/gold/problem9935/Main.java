package gold.problem9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static Stack<Character> stringStack;
    // 문자열을 입력받는 함수
    private static String getString() throws IOException {
        return br.readLine();
    }

    // 문자열에서 폭탄을 찾아 제거하는 함수
    private static String removeBomb(String originString, String bombString) {
        for (int i = 0; i < originString.length(); i++) {
            sb.append(originString.charAt(i));
            if(sb.length() >= bombString.length() && sb.charAt(sb.length()-1) == bombString.charAt(bombString.length()-1)) {
                Boolean check = true;
                for (int j = 1; j <= bombString.length(); j++) {
                    if (sb.charAt(sb.length() - j) != bombString.charAt(bombString.length() - j)) {
                        check = false;
                        break;
                    }
                }
                if(check) {
                    sb.delete(sb.length() - bombString.length(), sb.length());
                }
            }
        }
        return sb.toString();
    }

    // 문자열을 규칙에 맞춰 출력하는 함수
    private static void pringString(String answer) {
        if (answer.equals("")) {
            System.out.println("FRULA");
        }
        else {
            System.out.println(answer);
        }
    }

    public static void main(String[] args) throws IOException {
        String originString = getString();
        String bombString = getString();

        String answer = removeBomb(originString, bombString);
        pringString(answer);
    }
}
