class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for(int i = 0; i < n; i++) { 
            g.put(i, new ArrayList<>());
        }
        for(int[] edge : prerequisites) {
            g.get(edge[0]).add(edge[1]);// add nbrs
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];
        boolean[] visitedStack = new boolean[n]; // new array to keep track of visited nodes during current DFS traversal
        for(int i = 0; i < n; i++) { 
            if(visited[i] == false) {
                if(toposort(g, i, visited, visitedStack, stack) == false) { // check if topological sort is possible
                    return false;
                }
            }
        }
        if(stack.size() < n) { // check if topological sort is possible
            return false;
        }
        return true;
    }

    boolean toposort(Map<Integer, List<Integer>> g, int node, boolean[] visited, boolean[] visitedStack, Stack<Integer> stack) {
        visited[node] = true;
        visitedStack[node] = true; // mark node as visited during current DFS traversal
        for(int nbr : g.get(node)) {
            if(visited[nbr] == false) {
                if(toposort(g, nbr, visited, visitedStack, stack) == false) { // check if topological sort is possible
                    return false;
                }
            } else if(visitedStack[nbr] == true) { // check if node has been visited during current DFS traversal
                return false; // cycle detected, topological sort not possible
            }
        }
        visitedStack[node] = false; // mark node as not visited during current DFS traversal
        stack.add(node);
        return true;
    }
}