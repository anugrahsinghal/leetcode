class Solution {
    public int numIslands(char[][] grid) {
        // approach
        // keep visited as a log
        // and go thru each i,j here
        // and then dfs it
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(visited[i][j] == false && grid[i][j] == '1') {
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        if(grid[i][j] == '0' || visited[i][j] == true) return;

        visited[i][j] = true;
        dfs(grid, i-1, j, visited);
        dfs(grid, i+1, j, visited);
        dfs(grid, i, j+1, visited);
        dfs(grid, i, j-1, visited);
    }
}