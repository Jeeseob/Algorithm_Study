package Sort.Sort1;

// https://programmers.co.kr/learn/courses/30/lessons/42626
// Heap 문제 : 더 맵게

import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++) {
            // command에서 해당하는 subArray를 가져온다.
            int[] tempArray = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(tempArray);
            answer[i] = tempArray[commands[i][2]-1];
        }
        return answer;
    }
}

