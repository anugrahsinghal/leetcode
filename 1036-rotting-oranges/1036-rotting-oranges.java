class Solution {
    public int orangesRotting(int[][] grid) {
        // do not remember this
        // but looks like a BFS
        // one catch is that can have many graphs
        // so might need to get max of the different disjoint graphs
        var m = grid.length;
        var n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
    //     int[] maxDepth = new int[]{0};
    //     for(int i = 0; i < m; i++) { 
    //         for(int j = 0; j < n; j++) { 
    //             if(visited[i][j] == false && grid[i][j] == 2) {
    //                 dfs(grid, i, j, visited, maxDepth, 0);
    //             }
    //         } 
    //     }

    //     for(int i = 0; i < m; i++) { 
    //         for(int j = 0; j < n; j++) { 
    //             if(visited[i][j] == false && grid[i][j] == 1) {
    //                 return -1;
    //             }
    //         } 
    //     }

    //     return maxDepth[0];
    // }

    // public int orangesRotting(int[][] grid) {
        var q = new ArrayDeque<int[]>();
        for(int i = 0; i < m; i++) { 
            for(int j = 0; j < n; j++) { 
                if(grid[i][j] == 2) {
                    q.add(new int[]{i,j,0});
                }
            } 
        }

        int maxDepth = 0;
        while(!q.isEmpty()) {
            int[] val = q.poll();
            int i = val[0];
            int j = val[1];
            int depth = val[2];

            if(valid(i, j, grid) == false) continue;
            if(visited[i][j] == true || grid[i][j] == 0) continue;
            if(grid[i][j] == 1) {
                maxDepth = Math.max(maxDepth, depth);    
            } 
            visited[i][j] = true;
            

            q.add(new int[]{i+1, j, depth + 1});
            q.add(new int[]{i-1, j, depth + 1});
            q.add(new int[]{i, j+1, depth + 1});
            q.add(new int[]{i, j-1, depth + 1});
        }

        // System.out.println(Arrays.deepToString(grid));
        // System.out.println(Arrays.deepToString(visited));

        for(int i = 0; i < m; i++) { 
            for(int j = 0; j < n; j++) { 
                if(visited[i][j] == false && grid[i][j] == 1) {
                    return -1;
                }
            } 
        }

        return maxDepth;
    }

    boolean valid(int i, int j, int[][] grid) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return false;
        return true;
    }

    void dfs(int[][] grid, int i, int j, boolean[][] visited, int[] maxDepth, int depth) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        if(grid[i][j] == 0) return;
        if(visited[i][j] == true || grid[i][j] == 0) return;

        visited[i][j] = true;
        if(grid[i][j] == 1) {
            maxDepth[0] = Math.max(maxDepth[0], depth);
        }
        dfs(grid, i+1, j, visited, maxDepth, depth+1);
        dfs(grid, i-1, j, visited, maxDepth, depth+1);
        dfs(grid, i, j+1, visited, maxDepth, depth+1);
        dfs(grid, i, j-1, visited, maxDepth, depth+1);
    }

    static class Pair<K,V> {
        K key;
        V value;
        Pair(K k, V v) {
            key = k;
            value = v;
        }
        public K key() {
            return key;
        }
        public V value() {
            return value;
        }
        public boolean equals(Object _o) {
            Pair<K, V> o = (Pair<K, V>) _o;
            return this.key.equals(o.key) && this.value.equals(o.value);
        }
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }

}