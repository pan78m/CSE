#include <bits/stdc++.h>

using namespace std;
const int INF = 1e9;

int main()
{
    int n, m;
    cin >> n >> m;
    vector<int> dist(n + 1, INF);
    vector<vector<pair<int, int>>> g(n + 1);

    for (int i = 0; i < m; i++)
    {
        int u, v, w;
        cin >> u >> v >> w;
        g[u].push_back({v, w});
    }

    int destination;
    cin >> destination;
    dist[destination] = 0;
    set<pair<int, int>> sh;
    sh.insert({0, destination});

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
    }

    for (int i = 1; i <= n; i++)
    {
        if (dist[i] < INF)
            cout << dist[i] << "\t";
        else
            cout << -1 << "\t";
    }

    return 0;
}
