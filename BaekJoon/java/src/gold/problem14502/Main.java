package gold.problem14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static Queue<int[]> positionQueue = new LinkedList<>();
    private static ArrayList<int[]> blankPos = new ArrayList<>();
    static int maxYPos;
    static int maxXPos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        maxYPos = Integer.parseInt(st.nextToken());
        maxXPos = Integer.parseInt(st.nextToken());

        int[][] labBoard = new int[maxYPos][maxXPos];

        // 바이러스 위치 저장
        ArrayList<int[]> virusPos = new ArrayList<>();

        for(int i = 0; i < maxYPos; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < maxXPos; j++) {
                labBoard[i][j] = Integer.parseInt(st.nextToken());
                if(labBoard[i][j] == 0) {
                    blankPos.add(new int[]{i, j});
                }
                else if (labBoard[i][j] == 2) {
                    virusPos.add(new int[] {i,j});
                }
            }
        }

        int[][] tempLoadBoard = new int[maxYPos][maxXPos];
        int answer = 0;


        // 이게 최선일까...ㅠㅠ

        // 벽을 세울 수 있는 모든 경우의 수를 계산한다....
        for(int[] pos1 : blankPos) {
            for (int[] pos2 : blankPos) {
                if(pos1!=pos2) {
                    for (int[] pos3 : blankPos) {
                        if(pos1!=pos3 && pos2!=pos3) {
                            for(int i = 0; i < labBoard.length; i++) {
                                System.arraycopy(labBoard[i], 0, tempLoadBoard[i], 0, labBoard[0].length);
                            }
                            for(int[] virus : virusPos) {
                                positionQueue.add(virus);
                            }
                            tempLoadBoard[pos1[0]][pos1[1]] = 1;
                            tempLoadBoard[pos2[0]][pos2[1]] = 1;
                            tempLoadBoard[pos3[0]][pos3[1]] = 1;

                            answer = Math.max(answer, BFS(tempLoadBoard));
                            }
                        }
                    }
                }
            }
        System.out.println(answer);
    }

    // 길찾기(BFS)
    private static int BFS(int[][] labBoard) {
        int[] yAdd = {1, -1, 0, 0};
        int[] xAdd = {0, 0, 1, -1};

        while (!positionQueue.isEmpty()) {
            int[] tempPosition = positionQueue.poll();

            for(int i = 0; i < 4; i++) {
                int nextYPos = tempPosition[0] + yAdd[i];
                int nextXPos = tempPosition[1] + xAdd[i];

                if(nextXPos >= 0 && nextXPos < maxXPos && nextYPos >= 0 && nextYPos < maxYPos) {
                    if(labBoard[nextYPos][nextXPos] == 0) {
                        positionQueue.add(new int[] {nextYPos, nextXPos});
                        labBoard[nextYPos][nextXPos] = 2;
                    }
                }
            }
        }

        int answer = 0;
        for(int[] pos : blankPos) {
            if(labBoard[pos[0]][pos[1]] == 0) {
                answer++;
            }
        }

        return answer;
    }
}
