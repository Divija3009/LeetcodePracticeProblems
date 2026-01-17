import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Build the graph (prereq -> course)
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            adj.get(prereq).add(course);
        }

        // Step 3: Get topological sort
        ArrayList<Integer> topoList = topologicalSort(adj, numCourses);

        // Step 4: If not all nodes are in topo sort, return empty array
        if (topoList.size() != numCourses) {
            return new int[0];
        }

        // Step 5: Convert ArrayList to int[]
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = topoList.get(i);
        }

        return result;
    }

    // Topological sort using Kahn's Algorithm (BFS)
    public ArrayList<Integer> topologicalSort(List<List<Integer>> adj, int V) {
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                indegree[neighbor]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        return topo;
    }
}