public class Solution1 {

    // 프로그래머스 기지국 문제 2021.01.26
    // https://programmers.co.kr/learn/courses/10302/lessons/62946

    // 내가 푼 풀이 방법
    public int solution1(int n, int[] stations, int w) {
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

    // 간단하고 효율적인 풀이방법
    public int solution2(int n, int[] stations, int w) {
        int answer = 0;
        int gatewayPosition= 1; // 현재 위치
        int stationIndex = 0; // stations의 index

        // 아파트 동을 이동하면서, 기지국을 파악한다
        while(gatewayPosition <= n){
            // 이미 기지국의 영향력이 존재하는 영역에 도달한 경우
            if(stationIndex < stations.length && stations[stationIndex] - w <= gatewayPosition) {
                // 기지국의 영향력이 존재하지 않는 영역으로 gatewayPosition을 이동
                gatewayPosition = stations[stationIndex] + w + 1;
                // 다음 기지국을 가리키도록 인덱스 +1
                stationIndex++;

            } else {
                answer += 1; // 기지국이 하나 추가된다. (이때, 현재 위치가 아니라 현재 위치 + w에 추가된다고 생각)
                gatewayPosition += 2 * w + 1; // 기지국 하나의 도달거리만큼 이동
            }
        }
        return answer;
    }
}
