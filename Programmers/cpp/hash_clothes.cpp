/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578?language=cpp
 */

#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 1;
    unordered_map <string, int> clothe_type;
    for(int i = 0; i < clothes.size(); i++) {
        clothe_type[clothes[i][1]]++;
    }
    for(auto iter = clothe_type.begin(); iter != clothe_type.end(); iter++) {
        answer *= iter->second + 1;
    }
    return answer - 1;
}