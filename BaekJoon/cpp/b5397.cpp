#include<iostream>
#include<list>

using namespace std;

int main(){
    int commandCount;
    cin >> commandCount;

    for(int i = 0; i < commandCount; i++) {
        string inputLine;
        cin >> inputLine;
        list<char> answer;
        auto cursor = answer.begin();

        for(int i = 0; i < inputLine.length(); i++) {
            char temp = inputLine[i];
            if(temp == '<') {
                if(cursor != answer.begin()) {
                    cursor--;
                }
            }
            else if(temp == '>') {
                if(cursor != answer.end()) {
                    cursor++;
                }
            }
            else if(temp == '-') {
                if (cursor != answer.begin()) {
                    cursor--;
                    cursor = answer.erase(cursor);
                }
            }
            else {
                answer.insert(cursor, temp);
            }
        }
        for(auto tempAnswer : answer) {
            cout << tempAnswer;
        }
        cout << '\n';
    }
    return 0;
}