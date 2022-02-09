package Greedy.Greedy1;

// https://programmers.co.kr/learn/courses/30/lessons/42862
// Greedy 문제 : 체육복
import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 본인 운동복을 가지고 있는 학생 수
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 여벌이 있지만, 잃어버린 학생
        for (int i = 0; i < reserve.length; i++) {
            for(int j = 0; j < lost.length; j++) {
                if(lost[j] == reserve[i]) {
                    //이후에 같은 값이 나오지 않도록 lost와 reserve에 다른 값을 넣는다.
                    lost[j] = 0;
                    reserve[i] = -2;
                    answer++; // 체육수업을 들을 수 있는 학생 +1
                }
            }
        }

        for (int lostStudent : lost) {
            for (int i = 0; i < reserve.length; i++) {
                // 체육복을 빌릴 수 있는 경우, 값 제거
                if(lostStudent == reserve[i]-1) {
                    answer++;
                    reserve[i] = -2;
                    break;
                }
                else if(lostStudent == reserve[i]+1) {
                    answer++;
                    reserve[i] = -2;
                    break;
                }
            }
        }
        return answer;
    }
}
