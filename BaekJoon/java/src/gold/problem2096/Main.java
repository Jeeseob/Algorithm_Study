package gold.problem2096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int numberOfLine = Integer.parseInt(br.readLine());
        // 각 column별 가능한 최적의 수를 저장한다.
        int[] maxData = new int[3];
        int[] minData = new int[3];

        for (int i = 0; i < numberOfLine; i++) {
            st = new StringTokenizer(br.readLine());
            int[] index = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            int[] tempMaxData = maxData.clone();
            int[] tempMinData = minData.clone();

            // 이러면 반복문이 의미가 없을 듯...
            for(int j = 0; j < 3; j++) {
                if(j < 1) {
                    tempMaxData[j] = Math.max(maxData[j], maxData[j + 1]) + index[j];
                    tempMinData[j] = Math.min(minData[j], minData[j + 1]) + index[j];
                }
                else if(j > 1) {
                    tempMaxData[j] = Math.max(maxData[j], maxData[j - 1]) + index[j];
                    tempMinData[j] = Math.min(minData[j], minData[j - 1]) + index[j];
                }
                else {
                    tempMaxData[j] = Math.max(maxData[j], Math.max(maxData[j + 1], maxData[j - 1])) + index[j];
                    tempMinData[j] = Math.min(minData[j], Math.min(minData[j + 1], minData[j - 1])) + index[j];
                }
            }
            maxData = tempMaxData.clone();
            minData = tempMinData.clone();
        }

        System.out.print(Math.max(maxData[0], Math.max(maxData[1], maxData[2])) + " ");
        System.out.println(Math.min(minData[0], Math.min(minData[1], minData[2])));

        // bufferReader, bufferWriter는 닫아 주어야 한다.
        br.close();
    }
}