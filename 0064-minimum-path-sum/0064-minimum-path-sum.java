class Solution {
    public int minPathSum(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) { 
            Arrays.fill(dp[i], -1);
        }

        return minPath(m-1,n-1, dp, mat);
    }

    int minPath(int r, int c,int[][] dp, int[][] mat) {
        if(r < 0 || c < 0) return Integer.MAX_VALUE;
        if(r == 0 && c == 0) return mat[0][0];
        if(dp[r][c] != -1) return dp[r][c];

        int up = minPath(r-1, c, dp, mat);
        int left = minPath(r, c-1,dp, mat);
        dp[r][c] = mat[r][c] + Math.min(up, left);

        return dp[r][c];
    }
}