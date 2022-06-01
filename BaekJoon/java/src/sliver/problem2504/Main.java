package sliver.problem2504;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String data = br.readLine();

        Stack<Character> stack = new Stack<>();
        stack.push(data.charAt(0));
        int tempAnswer = 0;
        int answer = 0;
        for (int i = 1; i < data.length(); i++) {
            char temp = data.charAt(i);
            if (!stack.isEmpty()) {
                char now = stack.peek();
                if (temp == '(' && now == ')') {
                    stack.pop();
                    tempAnswer *= 2;
                }
                else if(temp == '[' && now == ']') {
                    stack.pop();
                    tempAnswer *= 3;
                }
                else {
                    stack.push(temp);
                }
            }
            else {
                answer += tempAnswer;
                tempAnswer = 0;
            }
        }

        if (!stack.isEmpty()) {
            System.out.println(0);
            System.exit(0);
        }
        System.out.println(answer);
    }
}
