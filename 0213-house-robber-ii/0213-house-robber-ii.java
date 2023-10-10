class Solution {
    public int rob(int[] arr) {
        int n = arr.length;
        if(n == 1) return arr[0];

        int withoutFirst = robHelper(arr, 1, n-1);
        int withoutLast = robHelper(arr, 0, n-2);

        return Math.max(withoutFirst, withoutLast);
    }

    public int robHelper(int[] arr, int startIdx, int endIdx) {
        int n = arr.length;
        int[] dp = new int[n+1];
        dp[startIdx] = arr[startIdx];
        for(int idx = startIdx+1; idx <= endIdx; idx++) { 
            int pick = arr[idx] + (idx-2 >= 0 ? dp[idx-2] : 0);
            int notPick = 0 + dp[idx-1];

            dp[idx] = Math.max(pick, notPick);
        }

        return dp[endIdx];
    }

}