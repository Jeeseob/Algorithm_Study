package BruteForce.BruteForce3;

// https://programmers.co.kr/learn/courses/30/lessons/42842
// BruteForce 문제 : 카펫


class Solution {
    public int[] solution(int brown, int yellow) {

        // 노랑색의 가로*2 + 세로*2 +4
        for(int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                if((i * 2) + (yellow/i*2) + 4 == brown) {
                    return new int[]{(yellow/i*2)+2, i+2};
                }
            }
        }
        return new int[]{1,1};
    }
}