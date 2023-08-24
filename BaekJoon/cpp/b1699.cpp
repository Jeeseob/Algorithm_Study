/**
 * https://www.acmicpc.net/problem/1699
 */

#include<iostream>

#define MAX 100000

using namespace std;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int X;
    cin >> X; 
    
    int dp[MAX];
    for(int i = 1; i <= X; ++i){
        dp[i] = i;
        for(int j = 1; j * j <= i; ++j){
            dp[i] = min(dp[i], dp[i - j * j] + 1);
        }
    }

    cout << dp[X];
}