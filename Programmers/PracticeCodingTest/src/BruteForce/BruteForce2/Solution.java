package BruteForce.BruteForce2;

// https://programmers.co.kr/learn/courses/30/lessons/42839
// BruteForce 문제 : 소수찾기

import java.util.HashSet;

class Solution {
    // 중복된 숫자가 있는경우, 값이 중복될 수 있어 Hash Set 사용
    private static HashSet<Integer> numberHashSet = new HashSet<>();

    // 소수의 개수를 반환해주는 함수
    public int countPrimeNumber(HashSet<Integer> numberHashSet) {
        int count = 0;
        Boolean check = true;
        for (int number : numberHashSet) {
            // 에라토스테네스의 체에 따라서, 제곱근까지의 자연수의 배수인지만 확인해도 소수여부를 판단할 수 있다.(연산량 감소)
            int sqrt = (int)Math.sqrt(number);
            for (int i = 2; i <= sqrt; i++) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
                check = true;
            }
            if(check) {
                count++;
                check = false;
            }
        }
        return count;
    }

    // DFS를 사용하여 전체 경우의 수 파악
    public void makeNumber(String tempNumber, String numbers) {
        if(!tempNumber.equals("")) {
            numberHashSet.add(Integer.parseInt(tempNumber));
        }
        for(int i = 0; i < numbers.length(); i++){
            makeNumber(tempNumber + numbers.charAt(i), numbers.substring(0,i) + numbers.substring(i+1));
        }
    }

    public int solution(String numbers) {

        makeNumber("",numbers);
        countPrimeNumber(numberHashSet);

        return countPrimeNumber(numberHashSet);
    }
}