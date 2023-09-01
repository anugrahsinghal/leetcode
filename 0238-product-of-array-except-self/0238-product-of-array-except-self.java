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

        int R = 1;
        // now for optimization
        for(int i = n-1; i >= 0; i--) {
            leftP[i] = R * leftP[i];
            R = R * nums[i];
        }
        
        return leftP;
    }
}