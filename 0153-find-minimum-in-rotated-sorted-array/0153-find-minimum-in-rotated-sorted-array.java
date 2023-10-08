class Solution {
    public int findMin(int[] nums) {
        // this question is basically how to find the pivot element
        // as in where the array got rotated
        int l = 0;
        int r = nums.length - 1;
        var res = nums[0];
        while(l <= r) {
            // if we have positioned l,r such that data is already sorted
            // then we get min value at l
            // and use as result and break
            if(nums[l] <= nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }
            
            var mid = (l+r) >>> 1;
            res = Math.min(res, nums[mid]);
            if(nums[mid] >= nums[l]) { // we are in left sorted part, so search on right
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return res;
    }
}