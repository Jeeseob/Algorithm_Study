#include <bits/stdc++.h>

using namespace std;

class Point {
public:
    int row;
    int column;

    Point(int row, int column) {
        this->row = row;
        this->column = column;
    }
};

int main() {
    int sizeOfRow;
    int sizeOfColumn;
    int dx[4] = {1, -1, 0, 0};
    int dy[4] = {0, 0, 1, -1};
    queue<Point> fireQueue;
    queue<Point> jihoonQueue;

    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> sizeOfRow >> sizeOfColumn;
    string board[sizeOfRow + 2];

    int fireDepth[sizeOfRow][sizeOfColumn];
    int jihoonDepth[sizeOfRow][sizeOfColumn];
    for(int i = 0; i < sizeOfRow; i++){
        fill(fireDepth[i], fireDepth[i]+sizeOfColumn, -1);
        fill(jihoonDepth[i], jihoonDepth[i]+sizeOfColumn, -1);
    }

    for (int i = 0; i < sizeOfRow; i++) {
        cin >> board[i];
    }
    for(int i = 0; i < sizeOfRow; i++){
        for(int j = 0; j < sizeOfColumn; j++){
            if(board[i][j] == 'F'){
                fireQueue.push(Point(i, j));
                fireDepth[i][j] = 0;
            }
            if(board[i][j] == 'J'){
                jihoonQueue.push(Point(i, j));
                jihoonDepth[i][j] = 0;
            }
        }
    }


    while (!fireQueue.empty()) {
        Point point = fireQueue.front();
        fireQueue.pop();
        int nextDepth = fireDepth[point.row][point.column] + 1;
        for (int i = 0; i < 4; i++) {
            int nextRow = point.row + dx[i];
            int nextColumn = point.column + dy[i];

            if (nextRow < 0 || sizeOfRow <= nextRow || nextColumn < 0 || sizeOfColumn <= nextColumn) continue;
            if (board[nextRow][nextColumn] == '#' || -1 != fireDepth[nextRow][nextColumn]) continue;
            fireDepth[nextRow][nextColumn] = nextDepth;
            fireQueue.push(Point(nextRow, nextColumn));

        }
    }

    while (!jihoonQueue.empty()) {
        Point point = jihoonQueue.front();
        jihoonQueue.pop();
        for (int i = 0; i < 4; i++) {
            int nextRow = point.row + dx[i];
            int nextColumn = point.column + dy[i];
            if (nextRow < 0 || sizeOfRow <= nextRow || nextColumn < 0 || sizeOfColumn <= nextColumn) {
                cout << jihoonDepth[point.row][point.column] + 1 << "\n";
                return 0;
            }
            if (board[nextRow][nextColumn] == '#') continue;
            if (jihoonDepth[nextRow][nextColumn] != -1 || fireDepth[nextRow][nextColumn] <= jihoonDepth[point.row][point.column] + 1) continue;
            jihoonDepth[nextRow][nextColumn] = jihoonDepth[point.row][point.column] + 1;
            jihoonQueue.push(Point(nextRow, nextColumn));
        }
    }
    cout << "IMPOSSIBLE\n";
    return 0;
}
