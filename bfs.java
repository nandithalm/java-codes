import java.util.*;

class Solution {
    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {

        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V];

        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {

            int node = queue.poll();
            result.add(node);

            for (int neighbor : adj.get(node)) {

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        return result;
    }
}
