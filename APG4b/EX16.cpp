#include <bits/stdc++.h>
using namespace std;

int main(){
    vector<int> data(5);
    for(int i=0;i<5;i++){
        cin >> data.at(i);
    }
    bool answer = false;
    for(int i=1;i<5;i++){
        if(data.at(i) == data.at(i-1)) answer = true;
    }
    if(answer){
        cout << "YES" << endl;
    } else {
        cout << "NO" << endl;
    }
}