class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        int l = helper(n-1,dp, cost);
        int r = helper(n-2,dp, cost);
        
        return Math.min(l, r);
    }

    int helper(int n,int[] dp, int[] cost) {
        if(n == 0) return cost[0];
        if(n == 1) return cost[1];
        if(dp[n] != -1) return dp[n];
        
        int left = helper(n-1, dp, cost);
        int right = Integer.MAX_VALUE;
        if(n-2>=0) {
            right = helper(n-2, dp, cost);
        }

        dp[n] = cost[n] + Math.min(left, right);

        return dp[n];
    }
}