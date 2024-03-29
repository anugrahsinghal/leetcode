class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return helper(n, dp);
    }

    int helper(int n, int[] dp) {
        if(n < 1) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(dp[n] != -1) {
            return dp[n];
        }
        
        int left = helper(n-1, dp);
        
        int right = 0;
        if(n-2>=0)
            right = helper(n-2, dp);
        
        dp[n] = left + right;

        return dp[n];
    }
}