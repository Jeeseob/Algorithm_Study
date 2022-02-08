package Sort.Sort3;

// https://programmers.co.kr/learn/courses/30/lessons/42747
// Sort 문제 : H-Index

import java.util.Arrays;
import java.util.Collections;

class Solution {
    // 같은 원리를 사용하였는데, solution이 solution2에 비해 10배가량 빠르다.
    // 객체로 다루는 것과, primitive type의 변수를 다루는 것은 속도차이가 큰 것같다.
    // 최대한 primitive  type을 사용하는 형태로 구현하려고 노력하자
    public int solution(int[] citations) {
        Arrays.sort(citations);

        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] <= citations.length - i) {
                return citations.length - i;
            }
        }
        return citations.length;
    }

    public int solution2(int[] citations) {
        // 내림차순으로 정렬 하기위해, Integer 배열로 변경
        Integer[] citationArray = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        // 내림차순 정렬
        Arrays.sort(citationArray, Collections.reverseOrder());

        // 논문 인용횟수(citationArray[i])와 논문 갯수를 비교(i)
        for (int i = 0; i < citations.length; i++) {
            if(citationArray[i] <= i) {
                return i;
            }
        }
        return citationArray.length;
    }
}