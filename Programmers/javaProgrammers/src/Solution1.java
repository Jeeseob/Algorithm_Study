public class Solution1 {

    // 프로그래머스 기지국 문제 2021.01.26
    // https://programmers.co.kr/learn/courses/10302/lessons/62946

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int count = 0; // 빈칸을 세기위한 변수
        int[] gateway = new int[n]; // 기지국 값을 나타내는 배열

        // 0으로 초기화
        for(int i = 0; i < n; i++) {
            gateway[i] = 0;
        }

        // 기지국 기준으로 +- w만큼의 값을 1로 변경
        for(int station : stations) {
            gateway[station-1] = 1; // 기지국 위치
            for(int j = 1; j <= w; j++){
                if(station-1-j >= 0){
                    gateway[station-1-j] = 1; // 기지국 -w까지
                }
                if(station-1+j < n) {
                    gateway[station-1+j] = 1; // 기지국 +w까지
                }
            }
        }

        // 증설이 필요한 기지국 갯수 확인
        for(int gate : gateway) {
            // 빈 공간이 몇칸인지 확인
            if(gate == 0) {
                count++;
            }
            // 빈공간이 끝나는 경우
            else {
                // 빈칸이 n개 일때, 필요한 기지국의 수는 n/(2*w+1)을 올림한 값
                answer += count/(2*w+1);
                if(count%(2*w+1) > 0) {
                    answer +=1;
                }
                count = 0;
            }
        }

        // 마지막이 빈칸으로 끝나는 경우
        if(gateway[n-1]==0) {
            // 마지막 빈칸에 대한 결과 값을 더해주는 로직 실행
            answer += count/(2*w+1);
            if(count%(2*w+1) > 0) {
                answer +=1;
            }
        }
        return answer;
    }
}
