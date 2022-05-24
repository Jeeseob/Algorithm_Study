package SkillCheck2.problem1;

import java.util.HashMap;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/05/24
 */

public class Solution {
    public int solution(String[][] clothes) {

        HashMap<String, Integer> hashMap = getHashMap(clothes);
        return getAnswer(hashMap);
    }

    private int getAnswer(HashMap<String, Integer> hashMap) {
        String[] keys = hashMap.keySet().toArray(new String[0]);

        int answer = 1;
        for (int i = 0; i < keys.length; i++) {
            answer *= hashMap.get(keys[i]);
        }
        return answer - 1;
    }

    private HashMap<String, Integer> getHashMap(String[][] clothes) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            hashMap.put(clothes[i][1], hashMap.getOrDefault(clothes[i][1], 1)+1);
        }
        return hashMap;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}}));
    }
}
