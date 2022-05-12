package sliver.problem18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] numberArray = new int[N];
        int[] sortArray = new int[N];
        getData(br, N, numberArray, sortArray);

        Arrays.sort(sortArray);

        HashMap<Integer, Integer> hashMap = getHashMap(sortArray);
        String answer = calcAsnwer(N, numberArray, hashMap);
        System.out.println(answer);
    }

    private static void getData(BufferedReader br, int N, int[] numberArray, int[] sortArray) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            numberArray[i] = temp;
            sortArray[i] = temp;
        }
    }

    private static HashMap<Integer, Integer> getHashMap(int[] sortArray) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int rank = 0;
        for (int i = 0; i < sortArray.length; i++) {
            int temp = sortArray[i];
            if (!hashMap.containsKey(temp)) {
                hashMap.put(temp, rank);
                rank++;
            }
        }
        return hashMap;
    }

    private static String calcAsnwer(int N, int[] numberArray, HashMap<Integer, Integer> hashMap) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int temp = numberArray[i];
            stringBuilder.append(hashMap.get(temp) + " ");
        }
        return stringBuilder.toString();
    }
}
