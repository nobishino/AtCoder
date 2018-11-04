#include<bits/stdc++.h>
using namespace std;
int main(){
    int n,m;
    cin >> n >> m;
    vector<vector<int>> table(n,vector<int>(n));
    for(int i=0;i<m;i++) {
        int a,b;
        cin >> a >> b;
        table.at(a-1).at(b-1) = 1;
        table.at(b-1).at(a-1) = -1;
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            int result = table.at(i).at(j);
            if (result == 1){
                cout << "o";
            } else if (result == -1) {
                cout << "x";
            } else {
                cout << "-";
            }
            if (j!=n-1) {
                cout << " ";
            } else {
                cout << endl;
            }
        }
    }
    return(0);
}