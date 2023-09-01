/**
 * https://www.acmicpc.net/problem/11055 
 */
#include<iostream>
#include<algorithm>

#define MAX 1001

using namespace std;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    int array[MAX];
    int dpArray[MAX];
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> array[i];
    }

    dpArray[0] = array[0];
    for(int i = 0; i < n - 1; i++) {
        int max = 0;
        for(int j = i; j >= 0; j--) {
            if(array[j] < array[i+1]) {
                max = std::max(max, dpArray[j]);
            }
            dpArray[i+1] = max + array[i+1];
        }
    }

    int answer = *max_element(dpArray, dpArray + n);
    cout << answer;

    return 0;
}