#include<iostream>
using namespace std;
//int largeste(int arr[],int n);
int largeste(int arr[],int n)
{
    int i,j;
// cout<<"array is";
    //for(i=0;i<n;i++){
      //  cout<<"\n"<<arr[i];
for(i=0;i<n;i++){
 //   cout<<arr[i];
    bool flag=true;
    for(j=0;j<n;j++){
        if(arr[j]>arr[i])
        {
            flag=false;
            break;
        }
    }
    if(flag==true)
    return i;
}
return -1;
}
int main()
{
    int arr[100],n,i,largest;
    cin>>n;
    for(i=0;i<n;i++){
        cin>>arr[i];
    }
    cout<<"array is";
    for(i=0;i<n;i++){
      cout<<"\n"<<arr[i];
   }
    largest=largeste(arr,n);
    cout<<"\nlargest="<<largest;
    return 0;
}
