/**
    Created at 2/22/24.
**/

#include <iostream>
#include <sstream>
#include <algorithm>
#include<deque>
using namespace std;

deque<int> makeDequeue(const string &inputStr);
void printResult(bool bResult, bool bReverse, deque<int> &dequeue);

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int numberOfTestCase = 0;
    cin >> numberOfTestCase;

    for (int i = 0; i < numberOfTestCase; i++) {
        bool bReverse = false;
        bool bResult = true;
        string functions;
        string inputStr;
        int arraySize;
        cin >> functions >> arraySize >> inputStr;
        deque<int> dequeue = makeDequeue(inputStr);

        for (auto function : functions) {
            if(function == 'R') {
                if(bReverse) {
                    bReverse = false;
                } else {
                    bReverse = true;
                }
            } else if(function == 'D') {
                if (dequeue.size() == 0) {
                    bResult = false;
                    cout << "error" << endl;
                    break;
                }
                if(bReverse) {
                    dequeue.pop_back();
                } else {
                    dequeue.pop_front();
                }
            } else {
                break;
            }
        }
        printResult(bResult, bReverse, dequeue);
    }
}

deque<int> makeDequeue(const string &inputStr){
    deque<int> dequeue;
    string temp = "";
    for(auto str : inputStr) {
        if(isdigit(str)) {
            temp += str;
        } else {
            if (!temp.empty()) {
                dequeue.push_back(stoi(temp));
                temp = "";
            }
        }
    }
    return dequeue;
}

void printResult(bool bResult, bool bReverse, deque<int> &dequeue){
    if(bResult) {
        cout << '[';
        if(bReverse) {
            while(dequeue.size()!=0) {
                cout << dequeue.back();
                dequeue.pop_back();
                if(dequeue.size() > 0) {
                    cout << ',';
                }
            }
        } else {
            while(dequeue.size()!=0) {
                cout << dequeue.front();
                dequeue.pop_front();
                if(dequeue.size() > 0) {
                    cout << ',';
                }
            }
        }
        cout << ']' << endl;
    }
}