class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        int start = 0;
        int end = rows;
        
        int idx = -1;
        
        while(start < end) {
            var mid = (start + end) >>> 1;
            var first = mat[mid][0];
            var last = mat[mid][cols-1];
            if(target >= first && target <= last) {
                idx = mid;
                break;
            } else if (target < first) {
                end--;
            } else {
                start++;
            }
        }
        
        if(idx == -1) {
            return false;
        }
        
        // System.out.println(idx);
        
        int i = 0;
        int j = cols;
        while(i < j) {
            var mid = (i + j) >>> 1;
            if(target == mat[idx][mid]) {
                return true;
            } else if (target < mat[idx][mid]) {
                j--;
            } else {
                i++;
            }
        }
        
        return false;
    }
}