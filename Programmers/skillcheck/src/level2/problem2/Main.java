package level2.problem1;


class Solution {
    private int answer;

    public int solution(int[] numbers, int target) {
        answer = 0;
        calc(numbers, target, 0, 0);
        return answer;
    }

    // 모든 경우의 수 계산
    public void calc(int[] numbers, int target, int temp, int count) {
        if(numbers.length <= temp) {
            if(count == target) {
                answer++;
                return;
            }
            else {
                return;
            }
        }
        calc(numbers, target, temp+1, count+numbers[temp]);
        calc(numbers, target, temp+1, count-numbers[temp]);
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1,1,1,1,1}, 3));
    }
}
