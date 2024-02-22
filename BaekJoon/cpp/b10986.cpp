/**
 * https://www.acmicpc.net/problem/10986
 */

#include <iostream>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int N;
    int M;
    int map[1000001] = {0};
    long prefixSum[1001] = {0};
    cin >> N >> M;

    for(int i = 0; i < N; i++) {
        cin >> map[i];
    }

    long temp = 0;
    for(int i = 0; i < N; i++) {
        temp += map[i];
        prefixSum[temp%M]++;
    }

    long result = prefixSum[0];
    for(int i = 0; i < M; i++) {
        result += (prefixSum[i] * (prefixSum[i]-1)) / 2;
    }

    cout << result << endl;
}

