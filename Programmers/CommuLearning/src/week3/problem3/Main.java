package week3.problem3;

// 올바른 괄호 개수 문제

class Solution {
    private int answer = 0;
    public int solution(int n) {
        recursiveDFS(0,0,n);
        return answer;
    }

    public void recursiveDFS(int leftSide, int rightSide, int n) {

        // '('가 ')'보다 적은 경우가 한번이라도 있다면, 완벽한 괄호가 아니다.
        if(leftSide < rightSide) {
            return;
        }

        if (leftSide == n && rightSide == n) {
            answer++;
            return;
        }

        // n쌍의 괄호는 각 모양의 개수가 n개를 넘지 못한다.
        else if(leftSide > n || rightSide > n) {
            return;
        }

        recursiveDFS(leftSide+1, rightSide,n);
        recursiveDFS(leftSide, rightSide+1, n);

        return;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3));
    }
}
