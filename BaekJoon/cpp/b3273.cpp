/**
 * https://www.acmicpc.net/problem/3273
 */
#include<iostream>
#include <algorithm>

using namespace std;

#define MAX 100002

int n;
int x;
int answer = 0;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int x;
    int array[MAX];

    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> array[i];
    }
    cin >> x;

    sort(array, array + n);
    int first = 0;
    int second = n - 1;

    while(first < second) {
        int sum = array[first] + array[second];
        if(sum == x) {
            answer++;
            first++;
            second--;
        } else if(sum < x) {
            first++;
        } else {
            second--;
        }
    }
    cout << answer;
    return 0;
}