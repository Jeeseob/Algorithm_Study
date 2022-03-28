package gold.problem9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int answer;
    private static int boardLength;
    private static int[] board;

    /**
     * 퀸 N개가 N*N의 보드에 모두 위치하기 위해서는
     * 각 행, 열 마다 하나씩의 퀸이 배치되어야 한다.
     */
    public static void main(String[] args) throws IOException {
        init();
        calcNQueen(0);
        System.out.println(answer);
    }

    // 객체 값 초기화
    private static void init() throws IOException {
        answer = 0;
        boardLength = readConsole();
        board = new int[boardLength];
    }

    // 콘솔에서 데이터 읽어오기
    private static int readConsole() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }

    // 가능한 Queen의 개수 계산
    private static void calcNQueen(int count) {
        if (count == boardLength) {
            answer++;
            return;
        }

        for(int i = 0; i < boardLength; i++) {
            if(isQueenPossible(count, i)) {
                board[count] = i;
                calcNQueen(count+1);
            }
        }
        return;
    }

    // 해당 위치에 Queen이 위치할 수 있는지 판단.
    private static Boolean isQueenPossible(int count, int data){

        // 기존 Queen과 같은 row인 경우 false
        for(int i = 0; i < count; i++) {
            if(board[i] == data) {
                return false;
            }
        }

        // 기존 Queen에 대각선에 위치한 경우 false
        for(int i = 0; i < count; i++) {
            if(board[i] + (count - i) == data || board[i] - (count - i) == data ) {
               return false;
            }
        }
        return true;
    }
}

