#include <bits/stdc++.h>
using namespace std;


void bubbleSort(vector<int> &arr ){
    if (arr.size() == 1 || arr.size() == 0){
        return;
    }

    bool swapped;
    for (int i = 0; i < arr.size(); i++){
        swapped = false;
        for (int j = 0; j < arr.size()-i-1; j++){

            if (arr[j+1] < arr[j]){
                swap(arr[j+1], arr[j]);
                swapped = true;
            }
        }
    }

    if(swapped==false){
        break;
    }
}

int main()
{
    int n;
    cin >> n;
    vector<int> arr;
    for (int i = 0; i < n; i++){
        int x;
        cin >> x;
        arr.push_back(x);
    }

    bubbleSort(arr);


    for (auto i : arr){
        cout << i << " ";
    }
    cout << endl;

    return 0;
}