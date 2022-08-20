class Solution {
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        int idx = -1;
        while(s <= e) {
            int mid = s + e >>> 1;
            if(nums[mid] == target) {
                idx = mid;
                break;
            }
            else if(target > nums[mid]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return idx;
    }
}