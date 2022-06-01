package sliver.problem2504;

import java.io.*;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();

        int temp = 1;
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) == '(') {
                stack.push('(');
                temp *= 2;
            }

            else if (in.charAt(i) == '[') {
                stack.push('[');
                temp *= 3;
            }

            else if (in.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    System.out.println(0);
                    System.exit(0);
                }
                else {
                    if (in.charAt(i - 1) == '(') {
                        answer += temp;
                    }
                    stack.pop();
                    temp /= 2;
                }
            }

            else if (in.charAt(i) == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    System.out.println(0);
                    System.exit(0);
                }
                else {
                    if (in.charAt(i - 1) == '[') {
                        answer += temp;
                    }
                    stack.pop();
                    temp /= 3;
                }
            }
        }
        System.out.println(!stack.isEmpty() ? 0 : answer);
    }
}