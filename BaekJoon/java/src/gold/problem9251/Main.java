package gold.problem9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstString = br.readLine();
        String secondString = br.readLine();

        System.out.println(longestCommonSubsequence(firstString, secondString));
    }
    // DP를 사용하여 해결할 수 있다.
    private static int longestCommonSubsequence(String firstString, String secondString) {
        int[][] dynamicArray = new int[firstString.length()+1][secondString.length()+1];

        for (int i = 0; i < firstString.length(); i++) {
            for (int j = 0; j < secondString.length(); j++) {
                // 둘이 같은 경우,
                if(firstString.charAt(i) == secondString.charAt(j)) {
                    dynamicArray[i+1][j+1] = dynamicArray[i][j] + 1;
                }
                else {
                    dynamicArray[i + 1][j + 1] = Math.max(dynamicArray[i][j + 1], dynamicArray[i + 1][j]);
                }
            }
        }
        return dynamicArray[firstString.length()][secondString.length()];
    }
}
