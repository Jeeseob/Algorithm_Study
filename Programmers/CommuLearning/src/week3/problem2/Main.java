package week3.problem2;

// 위장 문제

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private Queue<Position> positionQueue = new LinkedList<>();

    public int solution(int[][] maps) {
        // 목적지 좌표
        int xMax = maps[0].length - 1;
        int yMax = maps.length - 1 ;

        Position position = new Position(0, 0);
        positionQueue.add(position);

        // BFS
        while(!positionQueue.isEmpty()) {

            Position tempPosition = positionQueue.poll();

            int xPos = tempPosition.getxPos();
            int yPos = tempPosition.getyPos();

            // 4가지 방향에서 이동 가능한 좌표가 있는지 확인
            if(xPos > 0 && maps[yPos][xPos-1] != 0) {
                updatePostionData(xPos,yPos,xPos-1,yPos,maps);
            }
            if(xPos < xMax && maps[yPos][xPos+1] != 0) {
                updatePostionData(xPos,yPos,xPos+1,yPos,maps);
            }
            if(yPos > 0 && maps[yPos-1][xPos] != 0) {
                updatePostionData(xPos,yPos,xPos,yPos-1,maps);
            }
            if(yPos < yMax && maps[yPos+1][xPos] != 0) {
                updatePostionData(xPos,yPos,xPos,yPos+1,maps);
            }

        }

        // 목적지에 도달한 적이 없는 경우
        if(maps[yMax][xMax] <= 1) {
            return -1;
        }
        return maps[yMax][xMax]+1;
    }

    // next Postion의 값을 수정
    private void updatePostionData (int tempXPos, int tempYPos, int nextXPos, int nextYPos, int[][] maps ) {
        // 처음방문 하는 경우, queue에 해당 좌표를 넣어 해당 좌표로 이동할 수 있게 한다.
        if(maps[nextYPos][nextXPos] == 1) {
            positionQueue.add(new Position(nextXPos, nextYPos));
            maps[nextYPos][nextXPos] = maps[tempYPos][tempXPos] + 1;
        }
        // 이미 다른 방법으로 접근한 적이 있는 경우
        else if (maps[nextYPos][nextXPos] > maps[tempYPos][tempXPos]){
            maps[nextYPos][nextXPos] = maps[tempYPos][tempXPos] + 1;
        }
    }
}

class Position {
    private int xPos;
    private int yPos;

    public Position(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }
}

// 효율성에서 탈락( DFS는 중복이 많다)
class SolutionDFS {
    private static int xMax;
    private static int yMax;

    public int solution(int[][] maps) {
        int answer = 0;
        // 목적지 좌표
        xMax = maps[0].length - 1;
        yMax = maps.length - 1 ;

        return recursiveDFS(1, maps, 0, 0);
    }

    // DFS로 길을 찾는다.
    private int recursiveDFS(int answer, int[][] maps, int xPos, int yPos) {
        // 현재위치(x,y좌표가 n,m일 때, answer를 반환)
        if (xPos == xMax && yPos == yMax) {
            maps[yPos][xPos] = 1;
            return answer;
        }

        int[] answers = new int[4];

        // 현재위치로 다시 돌아오지 못하도록 현재위치에 벽 설치
        maps[yPos][xPos] = 0;

        // 4가지 방향에 대하여 재귀함수
        int count = 0;
        if (xPos > 0 && maps[yPos][xPos-1] == 1) {
            answers[0] = recursiveDFS(answer+1, maps, xPos-1, yPos);
            count++;
        }

        if (xPos < xMax && maps[yPos][xPos+1] == 1 ) {
            answers[1] = recursiveDFS(answer+1, maps, xPos+1, yPos);
            count++;
        }

        if (yPos > 0 && maps[yPos-1][xPos] == 1) {
            answers[2] = recursiveDFS(answer+1, maps, xPos, yPos-1);
            count++;
        }

        if(yPos < yMax && maps[yPos+1][xPos] == 1) {
            answers[3] = recursiveDFS(answer+1, maps, xPos,yPos+1);
            count++;
        }

        // 재귀를 돌고난 후, 다른 반복이 있을 수 있기 때문에, 현재 위치에 벽을 다시 없애준다.
        maps[yPos][xPos] = 1;

        // 현재위치에서 더이상 갈 곳이 없다면, -1 반환
        if(count == 0) {
            return -1;
        }

        int maxAnswer = Integer.MAX_VALUE;
        // 반환받은 값중 -1이 아닌 가장 작은 값을 반환.

        for(int tempAnswer : answers) {
            if(tempAnswer > 0) {
                maxAnswer = Math.min(tempAnswer, maxAnswer);
            }
        }

        // 값이 존재한다면 answer 반환
        if(maxAnswer != Integer.MAX_VALUE) {
            return maxAnswer;
        }

        // 값이 존재하지 않는 경우 -1 반환
        return -1;
    }
}


public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
    }
}
