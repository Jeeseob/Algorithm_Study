package hash4;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/42579
// Hash 문제 : 베스트앨범

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        HashMap<String,Integer> answerHashMap = new HashMap<>();
        Map<Integer,Integer> rank = new ArrayList<>();

        for(int i = 0; i < genres.length; i++){
            if (answerHashMap.containsKey(genres[i])) {
                answerHashMap.put(genres[i],plays[i]);
            }
            else {
                answerHashMap.put(genres[i], answerHashMap.get(genres[i]) + plays[i]);

            }
        }

        String[] genresRanking = answerHashMap.keySet().toString().split(", ");

        Arrays.sort(genresRanking, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return answerHashMap.get(o1).compareTo(answerHashMap.get(o2));
            }
        });

        





        return answer;
    }
}