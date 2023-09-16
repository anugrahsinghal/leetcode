class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int maxElement = prices[N-1];
        int maxProfit = 0;
        for(int i = N-1; i >= 0; i--) { 
            maxProfit = Math.max(maxProfit, maxElement - prices[i]);
            maxElement = Math.max(maxElement, prices[i]);
        }
        return maxProfit;
    }
}