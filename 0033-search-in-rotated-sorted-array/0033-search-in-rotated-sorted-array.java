class Solution {
    public int search(int[] nums, int target) {
        // find pivot as in mimum value element ka index
        // then identify which part to search
        // then do binary search again
        int minValIdx = findMinValIndex(nums);
        if(minValIdx == 0) {// non rotated
            return binarySearch(nums, 0, nums.length - 1, target);
        } else {
            // part a
            // 0 to minValIdx
            // part b
            // minValIdx to N-1

            //   i
            // 5 1 2 3 4
            if(target >= nums[minValIdx] && target <= nums[nums.length - 1]) {
                // search here min to end
                return binarySearch(nums, minValIdx, nums.length - 1, target);
            } else {
                // search here 0 to min - 1
                return binarySearch(nums, 0, minValIdx - 1, target);
            }
        }

        // return -1;
    }

    int binarySearch(int[] nums, int l, int r, int target) {
        System.out.printf("nums %s, l = %d, r = %d, target = %d", Arrays.toString(nums),l,r,target);
        while(l <= r) {
            var mid = (l+r) >>> 1;
            if(nums[mid] == target) {
                return mid;
            } else if(target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    int findMinValIndex(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int minVal = nums[0];
        int minIdx = 0;

        while(l <= r) {
            if(nums[l] <= nums[r]) {
                if(nums[l] <= minVal) {
                    minVal = nums[l];
                    minIdx = l;//Math.min(minIdx, l);
                }
            }

            var mid = (l+r) >>> 1;
            if(nums[mid] <= minVal) {
                minVal = nums[mid];
                minIdx = mid;//Math.min(minIdx, mid);
            }
            if(nums[mid] >= nums[l]) {// in left sorted part (as in rotated left)
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return minIdx;
    }
}