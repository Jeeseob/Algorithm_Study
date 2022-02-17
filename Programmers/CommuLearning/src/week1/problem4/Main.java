package week1.problem4;

import java.util.Arrays;
import java.util.Collections;

// 숫자 게임

class Solution {
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
