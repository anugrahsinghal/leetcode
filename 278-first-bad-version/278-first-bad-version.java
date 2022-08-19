/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // binary search
        int start = 1;
        int end = n;
        
        int lastBad = -1;
        /*
        - since looking for lower bound 
        - each time you find a result
            - store it
            - check for more result in with lesser upper bound **thus** `end = mid - 1`
        - else
          - increment the lower bound `start = mid+1`
        */
        while(start <= end) {
            int mid = start + end >>> 1;
            
            var isMidBad = isBadVersion(mid);
            //[1,2,3b,4b,5b,6b,7b]
            if(isMidBad) {
                lastBad = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        
        return lastBad;
    }
}