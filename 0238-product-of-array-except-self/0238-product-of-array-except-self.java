class Solution {
    public int[] productExceptSelf(int[] nums) {
        // AFAIK
        // needs me to calculate PREFIX sum
        // then when traversing from right, needs some trick that needed a 0 value
        int n = nums.length;
        int[] leftP = new int[n];
        int[] rightP = new int[n];
        leftP[0] = 1;
        rightP[n - 1] = 1;
        
        //      i
        // [1,1,0,0] leftP
        // [1,2,3,4] nums
        for(int i = 1; i < n; i++) {
            leftP[i] = leftP[i-1] * nums[i-1];
        }

        for(int i = n-2; i >= 0; i--) {
            rightP[i] = rightP[i+1] * nums[i+1];
        }

        int[] ans = new int[n];
        for(int i = 0; i < n; i++) { 
            ans[i] = leftP[i] * rightP[i];
        }
        
        return ans;
    }
}