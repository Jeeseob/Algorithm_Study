package sliver.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        MeetingTime[] meetings = new MeetingTime[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            meetings[i] = new MeetingTime(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // EndTime / StartTime 기준 오름차순 정렬
        Arrays.sort(meetings);
        int answer = calcAnswer(N, meetings);
        System.out.println(answer);
    }

    private static int calcAnswer(int N, MeetingTime[] meetings) {
        int answer = 0;
        int tempTime = -1;

        for (int i = 0; i < N; i++) {
            if(tempTime <= meetings[i].getStartTime()) {
                answer++;
                tempTime = meetings[i].getEndTime();
            }
        }
        return answer;
    }

    private static class MeetingTime implements Comparable<MeetingTime>{
        private int startTime;
        private int endTime;

        public MeetingTime(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        @Override
        public int compareTo(MeetingTime o) {
            int temp = this.endTime - o.getEndTime();
            if(temp != 0) {
                return temp;
            }
            // endTime이 같은경우, startTime을 기준으로 정렬
            return this.startTime -  o.getStartTime();
        }
    }
}
