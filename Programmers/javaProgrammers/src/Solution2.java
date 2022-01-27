import java.lang.*;
import java.util.*;

public class Solution2 {
    // 프로그래머스 가장 큰 수 직접 풀어보기 2021.01.27
    // https://programmers.co.kr/learn/courses/10302/lessons/62948

    public String solution2(int[] numbers) {
        String answer = "";
        String[] numbersToString = new String[numbers.length];

        // 데이터를 문자열로 변경하여 배열에 저장
        for(int i = 0; i < numbers.length; i++) {
            numbersToString[i] = String.valueOf(numbers[i]);
        }

        // sort 중 비교하는 로직을 변경(두 값을 합쳤을 때, 큰 값을 기준으로 정렬하면 된다)
        Arrays.sort(numbersToString, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                return (b+a).compareTo(a+b); // 문자열 두개를 더한 것을 비교
            }
        });
        // 값이 0으로만 구성된 경우, 0은 하나만 출력
        if (numbersToString[0].equals("0")) {
            return "0";
        }

        // sorting된 값을 기준으로 answer를 만든다.
        for(String ans : numbersToString) {
            answer += ans;
        }

        return answer;
    }
}
