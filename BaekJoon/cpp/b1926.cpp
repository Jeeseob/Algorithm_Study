#include <bits/stdc++.h>
using namespace std;

int sizeOfRow;
int sizeofColumn;
int numberOfDraw = 0;
int drawSize = 0;
int tempDrawSize = 0;
int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> sizeOfRow >> sizeofColumn;

    // 그림을 가운데로 두고, 4방향을 0으로 감싼다.(if문 줄이기)
    int board[sizeOfRow + 2][sizeofColumn + 2];
    int visited[sizeOfRow + 2][sizeofColumn + 2];

    queue<pair<int, int> > drawQueue;
    for(int row = 1; row <= sizeOfRow; row++) {
        for (int column = 1; column <= sizeofColumn; column++) {
            cin >> board[row][column];
        }
    }

    // 모든 좌표에 대해 BFS로 찾기
    for(int row = 1; row <= sizeOfRow; row++) {
        for (int column = 1; column <= sizeofColumn; column++) {
            if(board[row][column] == 1 && visited[row][column] != 1) {
                drawQueue.push(make_pair(row, column));
                visited[row][column] = 1;
                numberOfDraw += 1;
            }
            while(!drawQueue.empty()) {
                tempDrawSize++;
                pair<int,int> pointed = drawQueue.front();
                drawQueue.pop();
                int tempRow = pointed.first;
                int tempColumn = pointed.second;
                for (int i = 0; i < 4; ++i) {
                    int nextRow = tempRow + dx[i];
                    int nextColumn = tempColumn + dy[i];
                    if(board[nextRow][nextColumn] == 1 && visited[nextRow][nextColumn] != 1) {
                        drawQueue.push(make_pair(nextRow, nextColumn));
                        visited[nextRow][nextColumn] = 1;

                    }
                }
            }
            drawSize = max(drawSize, tempDrawSize);
            tempDrawSize = 0;
        }
    }

    cout << numberOfDraw << '\n' << drawSize;
    return 0;
}