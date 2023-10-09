class Solution {
    public boolean canJump(int[] jumpPower) {
        int n = jumpPower.length;
        int goalPostIdx = n-1; // (4idx)
        for(int currentIdx = n-2; currentIdx >= 0; currentIdx--) { // 
            if(currentIdx + jumpPower[currentIdx] >= goalPostIdx) { 
                // if at currentIdx you add jumpPower of currentIdx
                // if it can move past or upto goal post
                // then it mean we can reach goalpost from that index
                goalPostIdx = currentIdx;
            }
        }

        // if we reached 0 idx, means we can reach goalPost from 0 idx
        return goalPostIdx == 0;
        
    }
}