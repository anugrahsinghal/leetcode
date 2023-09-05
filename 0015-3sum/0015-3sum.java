class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();
        // [0,0,0] n = 3
        // i = 0 i < 3-2=1;i++
        // j = 1
        int i = 0;
        System.out.println(Arrays.toString(nums));
        while(i < n-2) {
            // duplicate remove
            // insetad of checking forward I am checking that if prev element was same
            // then new iteration does not make sense
            // this way if combo is [0,0,0,0,0]
            // `i` will not move to last 0 (index=2) and not work
            // but will do for first 0 and skip for other `0` zeroes
            if(i-1 >= 0 && nums[i-1] == nums[i]) {
                i++;
                continue;
            }
            int j = i + 1;
            int k = n-1;
            
            // System.out.println("loop for i = " + i);
            while(j < k) {
                int sum = nums[i]+nums[j]+nums[k];
                // System.out.printf("%d+%d+%d = %d",nums[i],nums[j],nums[k],sum);
                if(sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    // System.out.printf("--valid index = [%d,%d,%d]",i,j,k);
                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else if(sum < 0) {
                    j++;
                }
                // System.out.println();
            }
            i++;
        }

        return new ArrayList<>(ans);
    }
    /*
        for(int i = 0; i <= len - 3; i++) {
            if(nums[i] > 0) break;// from this point forward we will not have any 0 sum value combinations
            
            // keep in skipping same elements as they will lead to duplicate triplets
            if(i > 0 && nums[i] == nums[i-1]) continue;
            
            int lo = i+1;
            int hi = len - 1;// end
            
            while(lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if(sum == 0) {
                    List<Integer> al = Arrays.asList(nums[i], nums[lo], nums[hi]);
                    op.add(al);
                    lo++;
                    hi--;
                } else if(sum < 0) {
                    lo++;
                } else {
                    hi--;
                }
                
            }
            
            
            
        }

        
     */
}