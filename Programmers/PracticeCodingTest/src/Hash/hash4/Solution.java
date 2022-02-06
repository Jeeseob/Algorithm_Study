package Hash.hash4;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/42579
// Hash 문제 : 베스트앨범

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<Integer, String> indexHashMap = new HashMap<>(); // index를 기반으로 찾는 로직,
        HashMap<String, Integer>  totalPlayHashMap = new HashMap<>(); // generes의 값, plays의 값의 합 (genres간의 비교를 위함)

        ArrayList<Integer> answerArrayList = new ArrayList<>(); // 정답을 저장할 ArrayList


        for(int i = 0; i < genres.length; i++){
            if (totalPlayHashMap.containsKey(genres[i])) {
                // 해당 key를 가진 value가 존재하는 경우, 기존 value에 현재 값을 더한다.
                totalPlayHashMap.put(genres[i], totalPlayHashMap.get(genres[i]) + plays[i]);
            }
            else {
                totalPlayHashMap.put(genres[i], plays[i]);
            }
            // index를 key로 하기 때문에, 중복 확인 불필요
            indexHashMap.put(i, genres[i]);
        }

        // key값을 받아 playHashMap의 value값을 기반으로 내림차순 정렬
        String[] sortGenres = totalPlayHashMap.keySet().toArray(new String[0]);
        Arrays.sort(sortGenres, new Comparator<String>() {
            @Override
            public int compare(String key1, String key2) {
                return totalPlayHashMap.get(key2) - totalPlayHashMap.get(key1);
            }
        });


        // Genres값을 내림차순 순서대로 찾는다.
        for (String key : sortGenres) {
            ArrayList<Integer> tempArrayList = new ArrayList<>();
            // index를 기반으로 genres와 같은 value값을 찾아 ArrayList에 저장한다.
            for (int i = 0; i < genres.length; i++) {
                if (key.equals(indexHashMap.get(i))) {
                    tempArrayList.add(i);
                }
            }
            if(tempArrayList.size() < 2){
                // 값이 2개 미만일 때, 정렬 불필요
                answerArrayList.add(tempArrayList.get(0));
            }
            else {
                // key를 기준으로 받아온 index를 plays[index]를 기준으로하여 내림차순으로 정렬
                Integer[] sortPlays = tempArrayList.toArray(new Integer[0]);
                Arrays.sort(sortPlays, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer index1, Integer index2) {
                        return plays[index2] - plays[index1];
                    }
                });
                // 2개 이상이기 때문에, 위에서 부터 순서대로 2개 추가
                answerArrayList.add(sortPlays[0]);
                answerArrayList.add(sortPlays[1]);
            }
        }
        // ArrayList를 int 배열로 변경
        int[] answer = answerArrayList.stream().mapToInt(i->i).toArray();
        return  answer;
    }
}