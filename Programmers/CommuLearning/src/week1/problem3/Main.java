package week1.problem3;


import java.util.Arrays;
import java.util.stream.IntStream;

// 예산
// 95점 - 잘못된 풀이( 다시 풀어볼 것 )

class Solution {

    // 이분탐색을 활용한 풀이방법(정답 풀이)
    public int solutionInVideo(int[] budgets, int M)  {
        int answer = 0;
        int min = 0;
        //  numbers에서 가장 큰 값 -> optional로 뽑아오게 된다. 때문에 orElse를 활용해서 값이 없다면 0을 받아오게 만듬.
        int max = IntStream.of(budgets).max().orElse(0);

        while(min <= max) {
            final int middle = (min + max) / 2;

            // budgets의 값을 더하는데 이때, map을 통해 budget값에 조건을 단다.
            int sum = IntStream.of(budgets)
                // budget과 middle 중 작은 값을 budget으로 한다.
                .map(budget -> Math.min(budget,middle))
                .sum();

            // 아래의 코드를 IntStream으로 간략화 한 것.
//            int sum = 0;
//            for(int tempBudget : budgets) {
//                if(tempBudget < middle) {
//                    sum+=middle;
//                }
//                else {
//                    sum+=middle;
//                }
//            }

            if(sum <= M) {
                min = middle + 1;
                answer = middle;
            }
            else {
                max = middle - 1;
            }
        }
        return answer;
    }

    // 재귀를 활용한 풀이(오답 풀이)
    public int solution(int[] budgets, int M) {

        if(Arrays.stream(budgets).sum() <= M) {
            return Arrays.stream(budgets).max().getAsInt();
        }

        int length = budgets.length; // budgets의 길이
        int average = M/length; // 총예산을 기준으로 구한 평균
        int remainder = M%length; // 총예산을 기준으로 구한 나머지

        int index = 0;

        Arrays.sort(budgets); // 예산 순으로 정렬

        // 총 예산을 기준으로 평균을 구한다.
        for(int i = 0; i < length; i++) {
            if(budgets[i] > average) {
                index = i;
                break;
            }
            else {
                // 평균에서 초과되는 값을 나머지로 확인
                remainder += (average - budgets[i]);
            }
        }

        int remainderAverage = remainder / (length - index);

        // 바로 직후의 값이 계산한 상한액보다 크거나 같다면, 해당 값을 상한액으로 반환한다.
        if(budgets[index] >= average + remainderAverage ) {
            return average + remainderAverage;
        }

        // 만약 값이 나오지 않는 경우, 해당 과정을 반복한다.
        return solution(Arrays.copyOfRange(budgets, index, length), (average * (length - index))+ remainder);
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solutionInVideo(new int[]{120,110,140,150}, 485));
    }
}