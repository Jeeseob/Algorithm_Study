package sliver.problem1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int numberOfPocketmon = Integer.parseInt(st.nextToken());
        int numberOfQuiz = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> numbers = new HashMap<>();
        HashMap<String, Integer> strings = new HashMap<>();
        getData(br, numberOfPocketmon, numbers, strings);

        StringBuilder stringBuilder = new StringBuilder();
        findAnswer(br, numberOfQuiz, numbers, strings, stringBuilder);

        print(stringBuilder);
    }

    private static void getData(BufferedReader br, int numberOfPocketmon, HashMap<Integer, String> numbers, HashMap<String, Integer> strings) throws IOException {
        for (int i = 1; i <= numberOfPocketmon; i++) {
            String tempPocketmon = br.readLine();
            numbers.put(i, tempPocketmon);
            strings.put(tempPocketmon, i);
        }
    }

    private static void findAnswer(BufferedReader br, int numberOfQuiz, HashMap<Integer, String> numbers, HashMap<String, Integer> strings, StringBuilder stringBuilder) throws IOException {
        for (int i = 0; i < numberOfQuiz; i++) {
            String tempQuiz = br.readLine();
            if(strings.containsKey(tempQuiz)) {
                stringBuilder.append(strings.get(tempQuiz) + "\n");
            } else if (numbers.containsKey(Integer.parseInt(tempQuiz))) {
                stringBuilder.append(numbers.get(Integer.parseInt(tempQuiz)) + "\n");
            } else {
                stringBuilder.append("-1\n");
            }
        }
    }

    private static void print(StringBuilder stringBuilder) {
        System.out.println(stringBuilder);
    }
}
