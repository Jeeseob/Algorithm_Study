package Sort.Sort2;

// https://programmers.co.kr/learn/courses/30/lessons/42746?language=java
// Sort 문제 : 가장 큰 수

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        // int배열 -> Integer배열
        Integer[] numberInteger = Arrays.stream(numbers).boxed().toArray(Integer[]::new);

        // 정렬기준을 두 값을 붙인 값을 기준으로 내림차순 정렬
        Arrays.sort(numberInteger, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1,Integer o2) {
                String str1 = o1.toString();
                String str2 = o2.toString();
                return (str2+str1).compareTo(str1+str2);
            }
        });

        // 0000 은 0으로 출력해야 한다.
        if(numberInteger[0] == 0){
            return "0";
        }

        // 하나씩 붙여줌
        for(Integer number :numberInteger) {
            answer += number.toString();
        }

        return answer;
    }
}