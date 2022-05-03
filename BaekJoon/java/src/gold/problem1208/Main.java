package gold.problem1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    private static ArrayList<Integer> leftList = new ArrayList<>();
    private static ArrayList<Integer> rightList = new ArrayList<>();
    private static int[] numbers;


    private static int lengthOfNumbers;
    private static int targetNumber;
    private static long count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        lengthOfNumbers = Integer.parseInt(st.nextToken());
        targetNumber = Integer.parseInt(st.nextToken());

        numbers = new int[lengthOfNumbers];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < lengthOfNumbers; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        makeSum(0, 0, lengthOfNumbers/2, leftList);
        makeSum(0, lengthOfNumbers/2, lengthOfNumbers, rightList);

        Collections.sort(leftList);
        Collections.sort(rightList);

        count = 0;
        calcCount();

        print();
    }

    private static void print() {
        if(targetNumber == 0) {
            System.out.println(count - 1);
        }else {
            System.out.println(count);
        }
    }

    private static void calcCount() {
        // 투 포인터 방식으로, 두가지 배열을 두고, 더해가면서 계산한다.
        int rightPointer = 0;
        int leftPointer = leftList.size()-1;

        while(rightPointer < rightList.size() && leftPointer >= 0) {
            int rightValue = rightList.get(rightPointer);
            int leftValue = leftList.get(leftPointer);

            if (rightValue + leftValue == targetNumber) {
                long leftCount = 0;
                long rightCount = 0;
                while(leftPointer >= 0 && leftValue == leftList.get(leftPointer)) {
                    leftPointer--;
                    leftCount++;
                }
                while(rightPointer < rightList.size() && rightValue == rightList.get(rightPointer)) {
                    rightPointer++;
                    rightCount++;
                }
                // 경우의 수는 같은 값을 가진 수열들이 서로 적용될 수 있어 곱해줘야한다.
                count += leftCount * rightCount;
            }

            else if(rightValue + leftValue < targetNumber) {
                rightPointer++;
            }

            else {
                leftPointer--;
            }
        }
    }

    private static void makeSum(int sum, int start, int end, ArrayList<Integer> list) {
        if(start == end) {
            list.add(sum);
            return;
        }
        makeSum(sum, start+1, end, list);
        makeSum(sum + numbers[start], start+1, end, list);
    }
}
