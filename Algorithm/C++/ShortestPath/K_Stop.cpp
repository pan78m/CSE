#include <bits/stdc++.h>

using namespace std;
const int INF = 1e9;

int main()
{
    cout << "Hello World!!\n\n";

    int n, m;
    cin >> n >> m;
    vector<pair<int, int>> dist(n + 1, {INF, 0});
    vector<vector<pair<int, int>>> g(n + 1);

    for (int i = 0; i < m; i++)
    {
        int u, v, w;
        cin >> u >> v >> w;
        g[u].push_back({v, w});
        g[v].push_back({u, w});
    }

    int s, dst, K;
    cin >> s >> dst >> K;
    dist[s] = {0, 1};
    set<pair<int, pair<int, int>>> sh;

    for (int i = 1; i <= n; i++)
    {
        if (dist[i].first < INF)
            cout << dist[i].first << "\t";
        else
            cout << -1 << "\t";
    }
    cout << "\n";

    sh.insert({0, {1, s}});

    while (!sh.empty())
    {
        auto x = *(sh.begin());
        sh.erase(sh.begin());
        int node = x.second.second;
        int cost = x.first;
        int stops = x.second.first;

        if (stops > K)
            continue;

        for (auto i : g[node])
        {
            if (dist[i.first].first > cost + i.second)
            {
                sh.erase({dist[i.first].first, {dist[i.first].second, i.first}});
                dist[i.first] = {cost + i.second, stops + 1};
                sh.insert({dist[i.first].first, {dist[i.first].second, i.first}});
            }
        }

        for (int i = 1; i <= n; i++)
        {
            if (dist[i].first < INF)
                cout << dist[i].first << "\t";
            else
                cout << -1 << "\t";
        }
        cout << "\n";
    }

    cout << "Cheapest cost path with at most " << K << " stops from source " << s << " to destination " << dst << " is: ";
    if (dist[dst].first < INF)
        cout << dist[dst].first << endl;
    else
        cout << "No path found." << endl;

    return 0;
}
