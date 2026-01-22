import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    private int dfs(Map<Integer, List<Integer>> adj,
                    int curr,
                    int parent,
                    List<Boolean> hasApple) {

        int time = 0;

        for (int child : adj.get(curr)) {
            if (child == parent) continue;

            int childTime = dfs(adj, child, curr, hasApple);

            // if subtree has apple OR child itself has apple
            if (childTime > 0 || hasApple.get(child)) {
                time += 2 + childTime;
            }
        }

        return time;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {

        // build adjacency list
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return dfs(adj, 0, -1, hasApple);
    }
}
