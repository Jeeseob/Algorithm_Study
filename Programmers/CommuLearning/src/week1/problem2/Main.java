package week1.problem2;


import java.util.*;
import java.lang.*;

// 가장 큰 수
class Solution {
    public String solution(int[] numbers) {
        String answer ="";
        String[] numbersToString = new String[numbers.length];

        for( int i = 0; i < numbers.length; i++) {
            numbersToString[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(numbersToString, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                return (b+a).compareTo(a+b);
            }
        });

        // 모든 값이 0일 때, 예외처리
        if(numbersToString[0].equals("0")) {
            return "0";
        }

        for(String number : numbersToString) {
            answer += number;
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{2,2,6,8}));
    }
}