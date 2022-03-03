package week3.problem1;

// 위장 문제

import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1; // 곱연산을 진행하기 위해 1로 초기화

        HashMap<String, Integer> clothHash = new HashMap<>();

        // HashMap에 전체 데이터를 넣어, 카테고리별 옷의 갯수를 파악한다.
        for (String[] cloth : clothes) {
            if (clothHash.containsKey(cloth[1])) {
                clothHash.put(cloth[1], clothHash.get(cloth[1]) + 1);

            } else {
                clothHash.put(cloth[1], 1);
            }
        }
        // 파악한 값을 활용하여 가능한 경우의 수를 구한다.
        String[] keys = clothHash.keySet().toArray(new String[0]);

        for (String key : keys) {
            // 해당 카테고리의 옷을 안입는 경우도 있기 때문에 카테고리 값마다 + 1
            answer = answer * (clothHash.get(key) + 1);
        }
        // 옷을 전혀 안입는 경우는 없기 때문에 -1
        return answer-1;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}}));
    }
}
