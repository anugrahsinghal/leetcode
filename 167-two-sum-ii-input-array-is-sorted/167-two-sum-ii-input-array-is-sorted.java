class Solution {
    // [-2,7,11,15] | t = 9
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;//0
        int j  = numbers.length - 1;//3|2
        while(i<j) {//ok|ok|
            var sum = numbers[i] + numbers[j];//13|9
            if(sum == target) {//no
                return new int[]{i+1,j+1};
            } else if(sum < target) {//13 < 9 no |
                i++;//no
            } else {
                j--;//j=2
            }
        }
        
        return new int[]{-1,-1};
    }
    
    
    // [-2,7,11,15] target = 9
    /*  i       j
        i+j < target
        i++
        else j--
    
    
    
    */
}