/**
 * https://www.acmicpc.net/problem/7576
 */

#include<iostream>
#include<queue>
#include<algorithm>

using namespace std;

#define X first
#define Y second

int width = 0;
int height = 0;
int board[1000][1000];
queue<pair<int,int>> goodTomato;
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
int answer = 0;

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> width >> height;

    for(int tempY = 0; tempY < height; tempY ++ ) {
        for (int tempX = 0; tempX < width; tempX++) {
            cin >> board[tempX][tempY];
            if(board[tempX][tempY] == 1) {
                goodTomato.push({tempX, tempY});
            }
        }
    }

    while(!goodTomato.empty()){
        auto temp = goodTomato.front(); goodTomato.pop();
        for(int i = 0; i < 4; i++) {
            int nextX = temp.X + dx[i];
            int nextY = temp.Y + dy[i];

            if(nextX < 0 || nextX >= width || nextY < 0 || nextY >= height) {continue;}
            if(board[nextX][nextY] == 0) {
                board[nextX][nextY] = board[temp.X][temp.Y] + 1;
                goodTomato.push({nextX, nextY});
            }
        }
    }

    for(int tempY = 0; tempY < height; tempY ++ ) {
        for (int tempX = 0; tempX < width; tempX++) {
            int temp = board[tempX][tempY];
            if(temp == 0) {
                cout << -1;
                return 0;
            }
            answer = max(answer, temp);
        }
    }
    cout << answer-1;
}