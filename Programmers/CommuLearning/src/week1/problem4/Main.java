package week1.problem4;

import java.util.Arrays;
import java.util.Collections;

// 숫자 게임
// 오름차순 정렬을 위해, Integer 배열로 변경하는 방법을 사용했지만, 그냥 정렬하고 뒤에서 부터 for문을 돌려도 된다.
// 효율성 테스트를 통과했지만, 다소 비효율적인 코드이다. 효율적인 코드를 고려해보자

class Solution {

    public int solutionInVideo(int[] A, int[] B) {
        int answer = 0;
        int index = B.length - 1;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = A.length - 1; i >= 0; i--) {
            if(B[index] > A[i]) {
                answer++;
                index--;
            }
        }
        return answer;
    }

    public int solution(int[] A, int[] B) {
        int answer = 0;
        Integer[] integersA = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Arrays.sort(integersA, Collections.reverseOrder());

        Integer[] integersB = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(integersB, Collections.reverseOrder());

        int index = 0;
        Boolean win = false; // B가 이겼는지 여부 판단
        for(int i = 0; i < B.length; i++) {
            win = false;
            for(int j = index; j < integersA.length; j++) {
                // B의 값이 A보다 큰 경우, 이길 수 있다.
                if(integersB[i] > integersA[j]) {
                    // 값이 정렬되어 있어, 해당 값 보다 큰 수는 B팀에 없기 때문에 index를 옮긴다.
                    index = j+1;
                    win = true;
                    break;
                }
            }
            // 이긴 경우 answer++
            if(win) {
                answer++;
                win = false;
            }
        }

        return answer;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{5,1,3,7}, new int[]{2,2,6,8}));
    }
}
