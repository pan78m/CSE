// dijkstra
#include <bits/stdc++.h>
/*
@Pankaj Mahanto
@ ID: 213902002
Section:PC-213-DA

*/

using namespace std;
const int INF = 1e9;
int main()
{


    int n, m;
    cin >> n >> m;
    vector<int> dist(n + 1, INF);
    vector<vector<pair<int, int>>> g(n + 1); // index 0 theke suru nah korle eta korte hoy

    for (int i = 0; i < m; i++)
    {

        int u, v, w;
        cin >> u >> v >> w;
        // undirected graph
        g[u].push_back({v, w});
        g[v].push_back({u, w}); // single destination shortest path??
                                // je graph use korbo tar direction change kore dibo tahole seta single destination shortest path
                                // hoye jabe
    }
    // start node
    int s;
    cin >> s;
    dist[s] = 0;
    set<pair<int, int>> sh;

// print the initialize value which is -1
    for (int i = 1; i <= n; i++)
    {
        if (dist[i] < INF)
            cout << dist[i] << "\t";
        else
            cout << -1 << "\t";
    }
    cout << "\n";
    // print the table end here

    sh.insert({0, s}); // (dist[s],s)

    while (!sh.empty())
    {
        auto x = *(sh.begin());
        sh.erase(sh.begin());
        for (auto i : g[x.second])
        {

            if (dist[i.first] > dist[x.second] + i.second)
            {
                sh.erase({dist[i.first], i.first});
                dist[i.first] = dist[x.second] + i.second;
                sh.insert({dist[i.first], i.first});
              
           
            }
        }
        // print the initialize value which is -1
        for (int i = 1; i <= n; i++)
        {
            if (dist[i] < INF)
                cout << dist[i] << "\t";
            else
                cout << -1 << "\t";
        }
         cout << "\n";
          // print the table end here
    }

    // single pair shortest path
    cout << dist[4];

    // single destination shortest path
    cout << "\nSingle Source shortest path output\n";
  //  cout << "\nSingle Destination shortest path output\n";// jodi graph directed hoy and direction chage kore dei tahole eta single destinatio
    //destination shorest path hobe
    for (int i = 1; i <= n; i++)
    {
        cout << dist[i] << "  ";
    }

    return 0;
}
/*
6 8
1 2 2
1 3 4
2 4 7
3 5 3
4 6 1
5 4 2
5 6 5
2 3 1
*/