class Solution {
    public int rob(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n+1];
        dp[0] = arr[0];
        for(int idx = 1; idx <= n-1; idx++) { 
            int pick = arr[idx] + (idx-2 >= 0 ? dp[idx-2] : 0);
            int notPick = 0 + dp[idx-1];

            dp[idx] = Math.max(pick, notPick);
        }

        return dp[n-1];
    }

		// idx on first pass is n-1
		// that means we want to consider full array from 0-idx
		// and thus at idx we get the value
    int helper(int[] arr, int idx, int[] dp) {
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