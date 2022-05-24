package SkillCheck2.problem2;

import java.util.Arrays;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/05/24
 */
public class Solution {
    private int answer;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        Boolean[] clears = new Boolean[dungeons.length];
        Arrays.fill(clears, false);
        calc(clears, dungeons, k);
        return answer;
    }

    public void calc(Boolean[] clears,int[][] dungeons, int tempK) {
        int count = (int) Arrays.stream(clears).filter(i -> i).count();
        if(count > answer) {
            answer = count;
        }
        for (int i = 0; i < clears.length; i++) {
            if(clears[i]) continue;
            if(tempK >= dungeons[i][0]) {
                clears[i] = true;
                calc(clears, dungeons, tempK - dungeons[i][1]);
                clears[i] = false;
            }
        }
    }
}
class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(80, new int[][]{{80,20},{50,40},{30,10}}));
    }
}