package sliver.problem16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.
 *  - 2를 곱한다.
 *  - 1을 수의 가장 오른쪽에 추가한다.
 *
 * A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.
 */

class Data {
    private long data;
    private int tempAnswer;

    public long getData() {
        return data;
    }

    public int getTempAnswer() {
        return tempAnswer;
    }

    public Data(long data, int tempAnswer) {
        this.data = data;
        this.tempAnswer = tempAnswer;
    }
}

public class Main {

    private static long before;
    private static long after;
    public static void main(String[] args) throws IOException {
        readConsole();
        if (!clacBFS()) {
            System.out.println(-1);
        }
        return;
    }

    private static Boolean clacBFS() {
        Queue<Data> dataQueue = new LinkedList<>();
        dataQueue.add(new Data(before, 1));

        while(!dataQueue.isEmpty()) {
            Data tempData = dataQueue.poll();

            if (tempData.getData() == after) {
                System.out.println(tempData.getTempAnswer());
                return true;
            }

            if (tempData.getData() * 2 <= after) {
                dataQueue.add(new Data(tempData.getData() * 2, tempData.getTempAnswer() + 1));
            }

            String tempString = tempData.getData() + "1";
            long data = Long.valueOf(tempString);

            if (data <= after) {
                dataQueue.add(new Data(data, tempData.getTempAnswer() + 1));
            }
        }
        return false;
    }

    private static void readConsole() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        before = Long.valueOf(st.nextToken());
        after = Long.valueOf(st.nextToken());
    }
}
