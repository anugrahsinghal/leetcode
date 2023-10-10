class Solution {
    public int uniquePathsWithObstacles(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) { 
            Arrays.fill(dp[i], -1);
        }

        return paths(m-1,n-1,dp,mat,m,n);
    }

    int paths(int r, int c, int[][] dp, int[][] mat, int m, int n) {
        if(r < 0 || c < 0) return 0;
        if(mat[r][c] == 1) return 0;
        if(r == 0 && c == 0) return 1;
        if(dp[r][c] != -1) return dp[r][c];

        int up = paths(r-1, c, dp, mat, m, n);
        int left = paths(r, c-1, dp, mat, m, n);
        dp[r][c] = up+left;

        return dp[r][c];
    }
}