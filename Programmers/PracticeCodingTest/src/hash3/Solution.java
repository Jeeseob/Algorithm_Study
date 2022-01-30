package hash3;

import java.util.HashMap;

// https://programmers.co.kr/learn/courses/30/lessons/42578
// Hash 문제 : 위장

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> answerHash = new HashMap<String, Integer>();

        // Clothes에서 값을 가져와서 HashMap에 넣는다.
        for(String[] cloth : clothes) {
            if(answerHash.containsKey(cloth[1])) {
                // 값이 겹치는 경우 value에 1을 더해준다.
                answerHash.put(cloth[1], answerHash.get(cloth[1])+1);
            }
            else {
                answerHash.put(cloth[1], 1);
            }
        }

        // 문제 해결을 위해 실제 필요한 로직
        // 각 갯수에 + 1 을 한 값들을 곱해준 값에서 1을 빼면, 답이 나온다.
        for (String kindOfCloth : answerHash.keySet()) {
            answer *= answerHash.get(kindOfCloth) + 1;
        }
        return answer - 1;
    }
}
