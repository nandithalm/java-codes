import java.util.*;

class Solution {

    private void dfs(int node, ArrayList<ArrayList<Integer>> adj,
                     boolean[] vis, ArrayList<Integer> ls) {

        vis[node] = true;
        ls.add(node);

        for (int it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, adj, vis, ls);
            }
        }
    }

    public ArrayList<Integer> dfsOfGraph(int V,
                                         ArrayList<ArrayList<Integer>> adj) {

        boolean[] vis = new boolean[V];

        ArrayList<Integer> ls = new ArrayList<>();

        dfs(0, adj, vis, ls);

        return ls;
    }
}
