class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) { 
            Arrays.fill(dp[i], -1);
        }

        var min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) { 
            min = Math.min(min, helper(m-1, i, dp, triangle));
        }
        return min;
    }
    int helper(int r, int c, int[][] dp, List<List<Integer>> mat) {
        if(r < 0 || c < 0) return Integer.MAX_VALUE;
        if(c >= mat.get(r).size()) return Integer.MAX_VALUE;
        if(r == 0 && c == 0) return mat.get(0).get(0);
        if(dp[r][c] != -1) return dp[r][c];

        int up = helper(r-1, c-1, dp, mat);
        int left = helper(r-1, c, dp, mat); 
        dp[r][c] = mat.get(r).get(c) + Math.min(up, left);

        return dp[r][c];
    }
}