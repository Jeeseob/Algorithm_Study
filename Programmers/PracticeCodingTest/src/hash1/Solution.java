package hash1;

import java.util.HashMap;

// https://programmers.co.kr/learn/courses/30/lessons/42576
// Hash 문제 : 완주하지 못한 선수

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        // 정답을 저장할 HashMap 추가
        HashMap<String, Integer> answerHash = new HashMap<String, Integer>();
        int value = 0; // 이후 HashMap 에서의 value를 저장할 변수

        // 전체 참가자를 HahsMap으로 저장
        for(String name : participant) {
            // 이미 있는 사람인 경우(동명이인), value 값을 +1
            if(answerHash.containsKey(name)) {
                answerHash.put(name,answerHash.get(name)+1);
            }
            else {
                answerHash.put(name, 1);
            }
        }

        // 전체 참가자 중 완주한 참가자를 HashMap에서 제외
        for(String name : completion) {
            if(answerHash.containsKey(name)){
                // 현재 name에 대한 value
                value = answerHash.get(name);
                // 동명이인인 경우 value에서 1을 뺌
                if(value > 1) {
                    answerHash.put(name, value-1);
                }
                else {
                    answerHash.remove(name);
                }
            }
        }

        // HashMap에서 값을 String형태로 빼오는 방법(이런거 암기해두자)
        String temp = answerHash.keySet().toString();
        answer = temp.substring(1, temp.length()-1);

        return answer;
    }
}
