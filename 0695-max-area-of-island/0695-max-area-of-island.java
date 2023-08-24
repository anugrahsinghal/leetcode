class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] size = new int[1];
        int max = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] == false && grid[i][j] == 1) {
                    size[0] = 0;
                    dfs(grid, i, j, visited, size);
                    max = Math.max(max, size[0]);
                }
            }
        }

        return max;
    }

    void dfs(int[][] grid, int i, int j, boolean[][] visited, int[] size) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        if(visited[i][j] == true || grid[i][j] == 0) return;

        size[0]++;
        visited[i][j] = true;
        dfs(grid, i+1, j, visited, size);
        dfs(grid, i-1, j, visited, size);
        dfs(grid, i, j+1, visited, size);
        dfs(grid, i, j-1, visited, size);
    }
}