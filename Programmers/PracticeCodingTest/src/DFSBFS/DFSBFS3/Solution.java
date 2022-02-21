package DFSBFS.DFSBFS3;

// https://programmers.co.kr/learn/courses/30/lessons/43163
// DFS/BFS 문제 : 단어 변환

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

class Solution {
    public int solution(String begin, String target, String[] words) {

        // target이 words에 없는 경우, return 0
        if (Arrays.stream(words).noneMatch(a -> a.equals(target))) {
            return 0;
        }

        return recusiveSol(begin, target, words, Integer.MAX_VALUE, 0);
    }

    private int recusiveSol(String begin, String target, String[] words, int answer, int count) {
        // 현재를 기준으로, words에서 현재와 단어 1개가 차이나는 단어들을 배열로 받아온다.
        String[] findStrings = findDifference(begin,words);
        // 이 중, target과 일치하는 것이 있다면 반환한다
        if (Arrays.stream(findStrings).anyMatch(a -> a.equals(target))) {
            return count+1;
        }
        else {
            // 일치하는 것이 없다면 재귀함수를 돌린다.(count는 깊이, answer는 깊이 중 가장 작은 것 이다.)
            for(int i = 0; i < findStrings.length; i++) {
                int temp = Arrays.asList(words).indexOf(findStrings[i]);
                answer = Math.min(answer, recusiveSol(findStrings[i], target,
                        Stream.of(Arrays.copyOfRange(words, 0, temp),
                                        Arrays.copyOfRange(words, temp + 1, words.length)).
                                flatMap(Stream::of).toArray(String[]::new), answer, count+1));
            }
        }

        return answer;
    }

    private String[] findDifference(String begin, String[] words) {
        ArrayList<String> findStrings = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            int count = 0;
            for(int j = 0; j < begin.length(); j++) {
                if(begin.charAt(j) != words[i].charAt(j)) {
                    count++;
                    // 불필요한 반복을 막는다.
                    if(count > 1) {
                        break;
                    }
                }
            }
            if(count == 1) {
                findStrings.add(words[i]);
            }
        }
        return findStrings.toArray(String[]::new);
    }
}

