class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i < m; i++) { 
            Arrays.fill(dp[i], -1);
        }
        return paths(0,0,dp,m,n);
    }
    int paths(int r, int c, int[][] dp, int m, int n) {
        if(r >= m || c >= n) return 0;
        if(r == m-1 && c == n-1) return 1;
        if(dp[r][c] != -1) return dp[r][c];

        int le = paths(r+1, c, dp, m,n);
        int ri = paths(r, c+1, dp, m,n);

        dp[r][c] = le+ri;

        return dp[r][c];
    }
}