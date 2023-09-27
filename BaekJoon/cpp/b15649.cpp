/**
 * https://www.acmicpc.net/problem/15649
 */
#include<iostream>

#define MAX 9
using namespace std;

int N, M;

int temp[MAX] = {0,};
bool visited[MAX] = {0,};
void backTracking(int count) {
    if(count == M) {
        for(int i = 0; i < M; i++) {
            cout << temp[i] << " ";
        }
        cout << '\n';
        return;
    }
    for(int i = 0; i < N; i ++) {
        if(!visited[i]) {
            visited[i] = true;
            temp[count] = i+1;
            backTracking(count+1);
            visited[i] = false;
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    backTracking(0);
}