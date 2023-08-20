#include <bits/stdc++.h>
using namespace std;

int sizeOfRow;
int sizeofColumn;
int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};

class Point {
    public:
        int row;
        int column;
        int depth;

        Point(int row, int column, int depth) {
            this->row = row;
            this->column = column;
            this->depth = depth;
        }
};

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> sizeOfRow >> sizeofColumn;

    int board[sizeOfRow + 2][sizeofColumn + 2];
    int visited[sizeOfRow + 2][sizeofColumn + 2];
    string tempRow;
    for (int row = 1; row <= sizeOfRow; row++) {
        cin >> tempRow;
        for (int column = 1; column <= sizeofColumn; column++) {
            board[row][column] = tempRow[column - 1] - '0';
        }
    }

    queue<Point> bfsQueue;
    bfsQueue.push(Point(1,1,1));
    while(!bfsQueue.empty()) {
        Point point = bfsQueue.front();
        bfsQueue.pop();
        if(point.row == sizeOfRow && point.column == sizeofColumn) {
            cout << point.depth;
            return 0;
        }
        for (int i = 0; i < 4; ++i) {
            int nextRow = point.row + dx[i];
            int nextColumn = point.column + dy[i];
            if (board[nextRow][nextColumn] == 1 && visited[nextRow][nextColumn] != 1) {
                bfsQueue.push(Point(nextRow, nextColumn, point.depth + 1));
                visited[nextRow][nextColumn] = 1;
            }
        }
    }
    return 0;
}