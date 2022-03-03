package week3.problem4;

// 정수 삼각형 문제

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;

        // 위에서 부터 순서대로 모든 노드에 한번씩 방문한다.
        for(int dept = 1; dept < triangle.length; dept++) {
            for(int width = 0; width < triangle[dept].length; width++) {


                // 삼각형의 양쪽 끝에 위치한 노드의 경우 해당 위치로 도착할 수 있는 직전 노드가 1가지이다.
                // 삼각형의 왼쪽 끝
                if(width <= 0) {
                    triangle[dept][width] += triangle[dept-1][width];
                }

                // 삼각형의 오른쪽 끝
                else if(width == triangle[dept].length-1) {
                    triangle[dept][width] += triangle[dept-1][width-1];
                }

                // 삼각형의 중간인 경우 가능한 직전 노드가 2가지 이다.
                else {
                    // 두 값 중 큰 값을 더해준다.
                    triangle[dept][width] += triangle[dept-1][width-1] > triangle[dept-1][width] ? triangle[dept-1][width-1] : triangle[dept-1][width];
                }
            }
        }

        for (int tempAnswer : triangle[triangle.length - 1]) {
            answer = answer > tempAnswer ? answer : tempAnswer;
        }

        return answer;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }
}
