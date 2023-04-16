#include <bits/stdc++.h>

using namespace std;
int main()
{

    int n;
    cout << "Enter number of: ";
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        if (i % 2 == 0)
            continue;
        cout << i << " ";
    }

    cout << endl;

    return 0;
}