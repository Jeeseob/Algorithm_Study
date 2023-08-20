#include<iostream>
#include<list>

using namespace std;

int main(void) {
    cin.tie(0);
    string inputAnswer;
    cin >> inputAnswer;

    list<char> answer;

    for (auto c : inputAnswer) answer.push_back(c);

    auto cursor = answer.end();
    int repeatCount;
    cin >> repeatCount;
    for(int i = 0; i < repeatCount; i++) {
        char operation;
        cin >> operation;
        if (operation == 'P') {
            char addChar;
            cin >> addChar;
            answer.insert(cursor, addChar);
        }
        else if (operation == 'L') {
            if (cursor != answer.begin()) cursor--;
        }
        else if (operation == 'D') {
            if (cursor != answer.end()) cursor++;
        }
        else if(operation == 'B'){
            if (cursor != answer.begin()) {
            cursor--;
            cursor = answer.erase(cursor);
            }
        }
        else {
            cout << "Operation Error";
            return 0;
        }
    }
    for (auto c : answer) cout << c;
    cout << '\n';
    return 0;
}