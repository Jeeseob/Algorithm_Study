/**
 * https://www.acmicpc.net/problem/4179
 */


#include<iostream>
#include<queue>

using namespace std;

class Point {
    public:
        int x;
        int y;
        int count;
};


int board[1001][1001];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int maxX;
    int maxY;
    int jeeX;
    int jeeY;

    cin >> maxX >> maxY;
    queue<Point> pointQueue;

    for(int i = 0; i < maxX; i++) {
        for(int j = 0; j < maxY; j++) {
            char temp;
            cin >> temp;

            if(temp == '#') {
                board[i][j] = -2;
            } else if(temp == '.') {
                board[i][j] = 0;
            } else if(temp == 'F') {
                board[i][j] = -1;
                pointQueue.push({i,j,-1});
            } else if(temp == 'J') {
                jeeX = i;
                jeeY = j;
                board[i][j] = 1;
            } else {
                cout << "ERROR";
                return 0;
            }
        }
    }

    // jeehoon은 마지막에 추가
    pointQueue.push({jeeX,jeeY,1});

    if(jeeX == 0 || jeeX == maxX - 1 || jeeY== 0 || jeeY == maxY -1) {
        cout << 1;
        return 0;
    }

    while(!pointQueue.empty()) {
        Point tempPoint = pointQueue.front(); pointQueue.pop();
        for(int i = 0; i < 4; i++ ) {
            int nextX = tempPoint.x + dx[i];
            int nextY = tempPoint.y + dy[i];
            
            if(nextX < 0 || nextX >= maxX || nextY < 0 || nextY >= maxY) {continue;}
            if(board[nextX][nextY] < 0) {continue;}

            // jeehoon
            if(tempPoint.count > 0 && board[nextX][nextY] == 0) {
                if(nextX == 0 || nextX == maxX - 1 || nextY== 0 || nextY == maxY -1) {
                    cout << tempPoint.count + 1;
                    return 0;
                }

                board[nextX][nextY] = -1;
                pointQueue.push({nextX, nextY, tempPoint.count + 1});
            } else if(board[tempPoint.x][tempPoint.y] == -1) {
                board[nextX][nextY] = -1;
                pointQueue.push({nextX, nextY, -1});
            }
        }
    }

    cout << "IMPOSSIBLE";
    return 0;
}

// 2 2
// JF
// FF