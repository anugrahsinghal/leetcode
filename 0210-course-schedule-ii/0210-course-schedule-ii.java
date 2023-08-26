class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for(int i = 0; i < n; i++) { 
            g.put(i, new ArrayList<>());
        }
        for(int[] edge : prerequisites) {
            g.get(edge[0]).add(edge[1]);// add nbrs
        }

        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[n];
        for(int i = 0; i < n; i++) { 
            if(visited[i] == 0) {
                if(toposort(g, i, visited, stack) == false) { // check if topological sort is possible
                    return new int[]{}; // not possible
                }
            }
        }

        int[] ans = new int[n];
        int k = n-1;

        while(stack.size() > 0) {
            ans[k--] = stack.pop();
        }
        
        return ans;
    }

    boolean toposort(Map<Integer, List<Integer>> g, int node, int[] visited, Stack<Integer> stack) {
        visited[node] = 1;
        for(int nbr : g.get(node)) {
            if(visited[nbr] == 0) { // not visited
                if(toposort(g, nbr, visited, stack) == false) {
                    return false;
                }
            } else if(visited[nbr] == 1) { // if is in visting state - that is we found cycle
                return false; // cycle detected, topological sort not possible
            }
        }
        visited[node] = 2;// fully visited
        stack.add(node);
        return true;
    }
    
}
