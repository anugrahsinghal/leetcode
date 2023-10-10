class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(nums, n-1, dp);
    }

    static int helper(int[] arr, int idx, int[] dp) {
		if(idx < 0) return 0;
		if(idx == 0) return arr[0];	
		if(dp[idx] != -1) return dp[idx];

		// cant choose adjacent so idx-2
		int pick = arr[idx] + helper(arr, idx-2, dp);
		int notPick = 0 + helper(arr, idx-1, dp);

		dp[idx] = Math.max(pick, notPick);

		return dp[idx];
	}
}