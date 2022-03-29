package platinum.problem2957;

import java.io.*;
import java.util.TreeSet;

/**
 * 트리나 그래프 문제라고 무조건 Node를 만들어 적용하려고 하지말자.
 * 배열 형태로 사용하는 것이 빠를 수 있다.
 *
 * 자바 표준라이브러리의 자료구조들을 잘 활용하자.
 */
public class Main {

    private static int treeLength;
    private static int[] numbers;
    private static TreeSet<Integer> depthSet;
    private static int[] depths;

    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        readConsole();
        calcDepth();
        System.out.print(stringBuilder.toString());
        return;
    }

    // 깊이를 계산한다.
    private static void calcDepth() {
        initCalcDepth();

        long tempAnswer = 0;
        for (int i = 0; i < treeLength; i++) {
            int temp = numbers[i];
            depths[temp] = Math.max(depths[depthSet.lower(temp)], depths[depthSet.higher(temp)]) + 1 ;
            depthSet.add(temp);
            tempAnswer += depths[temp];
            makeString(tempAnswer);
        }
    }

    // calcDepth 전 변수 세팅
    private static void initCalcDepth() {
        depths = new int[treeLength+2];
        depthSet = new TreeSet<>();

        depthSet.add(0);
        depthSet.add(treeLength + 1);
        depths[0] = -1;
        depths[treeLength+1] = -1;
    }

    // 콘솔에서 데이터를 읽어온다.
    private static void readConsole() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        treeLength = Integer.parseInt(bufferedReader.readLine());
        numbers = new int[treeLength];

        for (int i = 0; i < treeLength; i++) {
            numbers[i] = Integer.parseInt(bufferedReader.readLine());
        }
        bufferedReader.close();
    }

    // 출력 String 만들기
    private static void makeString(long answer){
        stringBuilder.append(answer+"\n");
    }
}
