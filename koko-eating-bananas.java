class Solution {
    int max(int[] piles) {
        int max = piles[0];
        for(int p : piles) {
            max = Math.max(max, p);
        }
        return max;
    }
    public int minEatingSpeed(int[] piles, int H) {
        int min = 1;
        int max = max(piles);
        
        int res = max;//Integer.MAX_VALUE;
        while(min <= max) {
            // System.out.printf("Min = %d, Max = %d -- ", min, max);
            int mid = (min+max) >>> 1;
            
            long hours = 0;// can cause overflow so use long
            for(int p : piles) {
                hours += (int) Math.ceil((double)p / mid);
            }
            // System.out.printf("AT speed %d, time = %d\n", mid, hours);
            
            if(hours <= H) {
                res = Math.min(res, mid);
                // since already storing result 
                // we want to search the values lower and need not consider 
                // current value
                max = mid-1;
            } else {
                // we want to search the values larger and need not consider 
                // current value
                min = mid+1;
            }
        }
        
        return res;
    }
}
