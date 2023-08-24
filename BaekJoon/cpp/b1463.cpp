/**
 *  https://www.acmicpc.net/problem/1463
 */

#include<iostream>
#include <cstring>

#define MAX 1000000

using namespace std;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int board[MAX];
    memset(board, MAX, sizeof(board));

    int X;
    cin >> X;

    board[1] = 0;
    for(int i = 1; i < X; i++) {
        board[i+1] = min(board[i+1], board[i] + 1);
        if(i*2 > MAX) {continue;}
        board[i*2] = min(board[i*2], board[i] + 1);
        if(i*3 > MAX) {continue;}
        board[i*3] = min(board[i*3], board[i] + 1);
    }

    cout << board[X];
}