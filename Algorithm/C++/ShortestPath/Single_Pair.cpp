#include <bits/stdc++.h>

using namespace std;
const int INF = 1e9;

int main()
{
    cout << "Hello World!!\n\n";

    int n, m;
    cin >> n >> m;
    vector<int> dist(n + 1, INF);
    vector<vector<pair<int, int>>> g(n + 1);

    for (int i = 0; i < m; i++)
    {
        int u, v, w;
        cin >> u >> v >> w;
        // undirected graph
        g[u].push_back({v, w});
        g[v].push_back({u, w});
    }

    int source, destination;
    cin >> source >> destination;
    dist[source] = 0;
    set<pair<int, int>> sh;
    sh.insert({0, source});

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

    // Single Pair Shortest Path
    cout << "Shortest distance from " << source << " to " << destination << ": ";
    if (dist[destination] < INF)
        cout << dist[destination] << endl;
    else
        cout << "No path exists." << endl;

    return 0;
}
