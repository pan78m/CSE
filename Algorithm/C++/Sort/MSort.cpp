#include <bits/stdc++.h>
using namespace std;

void Merge(int Arr[], int l, int mid, int r)
{int l[l],r[r],k;

}
void MergeSort(int Arr[], int l, int r)
{
    int mid;
    if (l < r)
    {
        mid = (l + r / 2);
        MergeSort(Arr, mid + 1, r);
        MergeSort(Arr, l, mid);
    }
    Merge(Arr, l, mid, r);
}
void PrintArr(int Arr[], int n)
{
    for (int i = 0; i < n; i++)
    {
        cout << Arr[i] << "  ";
    }
}
int main()
{
    int n;
    cout << "Enter the Terms of Number: ";
    cin >> n;
    int Arr[n];
    // insert the value in Array
    for (int i = 0; i < n; i++)
    {
        int v;
        cin >> v;
        Arr[i] = v;
    }
    // Print the Array before sort
    PrintArr(Arr, n);
    int l = 0;
    int r = n - 1;
    MergeSort(Arr, l, r);

    return 0;
}