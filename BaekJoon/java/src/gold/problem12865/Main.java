package gold.problem12865;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// 다이나믹 프로그래밍 원리부터 다시 공부해보자..
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int numberOfProduct = Integer.parseInt(st.nextToken());
        int maxWeight = Integer.parseInt(st.nextToken());

        int[] weights = new int[numberOfProduct + 1]; // 무게
        int[] values = new int[numberOfProduct + 1]; // 가치
        int[] dpArray = new int[maxWeight + 1];

        for (int i = 1; i <= numberOfProduct; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        for (int productIndex = 1; productIndex <= numberOfProduct; productIndex++) {
            // K부터 탐색하여 담을 수 있는 무게 한계치가 넘지 않을 때까지 반복
            for (int dpIndex = maxWeight; dpIndex - weights[productIndex] >= 0; dpIndex--) {
                dpArray[dpIndex] = Math.max(dpArray[dpIndex], dpArray[dpIndex - weights[productIndex]] + values[productIndex]);
            }
        }
        System.out.println(dpArray[maxWeight]);
    }
}

// DFS 사용 - 시간초과

//import java.util.ArrayList;
//import java.util.Scanner;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;

//public class Main {
//
//    public static void main(String[] args) {
//	    // write your code here
//        Scanner scanner = new Scanner(System.in);
//
//        int repitation = scanner.nextInt();
//        ArrayList<int[]> productList = new ArrayList<>();
//
//        int maxWeight = scanner.nextInt();
//
//        for(int i = 0; i < repitation; i++) {
//            productList.add(new int[] {scanner.nextInt(), scanner.nextInt()});
//        }
//
//        System.out.println(recursiveDFS(0, 0, maxWeight, productList));
//
//    }
//
//    private static int recursiveDFS(int countValue, int countWeight, int maxWeight, ArrayList<int[]> productList) {
//        if(countWeight == maxWeight) {
//            return countValue;
//        }
//
//        int answer = 0;
//        for (int i = 0; i < productList.size(); i++) {
//            if(countWeight + productList.get(i)[0] <= maxWeight) {
//                answer = Math.max(answer, recursiveDFS(countValue + productList.get(i)[1], countWeight + productList.get(i)[0], maxWeight,
//                        (ArrayList<int[]>) Stream.concat(productList.subList(0, i).stream(), productList.subList(i + 1, productList.size()).stream())
//                                .collect(Collectors.toList())));
//            }
//        }
//
//        return answer == 0 ? countValue : answer;
//    }
//}
