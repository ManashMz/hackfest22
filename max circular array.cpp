// C++ program for maximum contiguous circular sum problem
#include <bits/stdc++.h>
using namespace std;

int kadane(int a[], int n);
int maxCircularSum(int a[], int n)
{
	int max_kadane = kadane(a, n);
	if(max_kadane < 0)
	return max_kadane;
int max_wrap = 0, i;
	for (i = 0; i < n; i++) {
		max_wrap += a[i]; // Calculate array-sum
		a[i] = -a[i]; // invert the array (change sign)
	}
	max_wrap = max_wrap + kadane(a, n);

	return (max_wrap > max_kadane) ? max_wrap : max_kadane;
}

int kadane(int a[], int n)
{
	int max_so_far = 0, max_ending_here = 0;
	int i;
	for (i = 0; i < n; i++) {
		max_ending_here = max_ending_here + a[i];
		
		if (max_so_far < max_ending_here)
			max_so_far = max_ending_here;
		if (max_ending_here < 0)
			max_ending_here = 0;
	}
	return max_so_far;
}
int main()
{
	int a[] = { 11, 10, -20, 5, -3, -5, 8, -13, 10 };
	int n = sizeof(a) / sizeof(a[0]);
	cout << "Maximum circular sum is " << maxCircularSum(a, n) << endl;
	return 0;
}
