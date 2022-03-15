package gold.problem1918;

import java.util.*;

public class Main {
    private static Stack<String> operatorStack;
    private static String answer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String originString = scanner.nextLine();

        ArrayList<String> originStrings = new ArrayList<>();

        answer = "";
        operatorStack = new Stack<>();

        for (int i = 0; i < originString.length(); i++) {
            originStrings.add(String.valueOf(originString.charAt(i)));
        }

        for(int i = 0; i < originStrings.size(); i++) {
            String tempString = originStrings.get(i);

            // ( 는 그냥 넣으면 됨
            if (tempString.equals("(")) {
                operatorStack.add(tempString);
            }

            // )는 (를 찾을 때까지 연산자 모두 출력
            else if (tempString.equals(")")) {
                while (!operatorStack.isEmpty()) {
                    if (operatorStack.peek().equals("(")) {
                        operatorStack.pop();
                        break;
                    }
                    answer += operatorStack.pop();
                }
            }

            // 연산자인 경우, 연산자 우선순위가 높은게 앞에 있는건 괜찮지만, 그렇지 않은 경우는 출력후에 넣는다.
            else if ("+-*/".indexOf(tempString) != -1) {
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(tempString) && !operatorStack.peek().equals("(")) {
                    answer += operatorStack.pop();
                }
                operatorStack.add(tempString);
            }

            else {
                answer += tempString;
            }

        }

        while (!operatorStack.isEmpty()) {
            answer += operatorStack.pop();
        }
        System.out.println(answer);
    }

    public static int precedence(String operator){
        if (operator.equals("+") || operator.equals("-")) {
            return 1;
        }
        return 2;
    }
}

