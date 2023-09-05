class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length -  1;
        while(i < j) {
            var ans = numbers[i] + numbers[j];
            if(ans == target) {
                return new int[]{i+1,j+1};
            }
            if(ans > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[]{-1,-1};
    }
}