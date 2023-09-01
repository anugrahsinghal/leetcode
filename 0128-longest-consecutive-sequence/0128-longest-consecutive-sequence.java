class Solution {
    public int longestConsecutive(int[] _nums) {
        // this also I remember was something tricky
        // on the lines of
        // go from number to every next number
        // if it is there in set the you will find it
        // else move to next
        Set<Integer> nums = new HashSet<>();
        
        for(int num : _nums) {
            nums.add(num);
        }
        int maxC = 0;
        int c = 0;
        for(int num : _nums) {
            if(nums.contains(num - 1) == false) {// start of a sequence
                c = 1;
                int i = num + 1;
                while(nums.contains(i)) {
                    i++;
                    c++;
                }
            }
            maxC = Math.max(c, maxC);
            c = 0;
        }
        
        return maxC;
    }
}