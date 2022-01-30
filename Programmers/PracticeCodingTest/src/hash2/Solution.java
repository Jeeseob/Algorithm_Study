package hash2;

import java.util.HashMap;

// https://programmers.co.kr/learn/courses/30/lessons/42577
// Hash 문제 : 전화번호 목록

class Solution {
    // 효율성 3,4번은 통과하지 못한 코드 (Hash 사용 X)
//    public boolean solution(String[] phone_book) {
//        Arrays.sort(phone_book);
//        for(int i = 0; i < phone_book.length; i++) {
//            for(int j = i+1; j < phone_book.length; j++) {
//                if(phone_book[j].startsWith(phone_book[i])) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> answerHashMap = new HashMap<>();

        // 전화번호 목록을 HashMap에 입력
        for(int i = 0; i < phone_book.length; i++) {
            answerHashMap.put(phone_book[i], i);
        }

        for(String phoneNumber : phone_book) {
            for (int j = 1; j < phoneNumber.length(); j++) {
                // 각 phoneNumber의 substring 중 key값이 있다면, 해당 값이 접두사이다.
                if (answerHashMap.containsKey(phoneNumber.substring(0, j))) {
                    System.out.println(phoneNumber.substring(0,j));
                    return false;
                }
            }
        }
        return true;
    }
}
