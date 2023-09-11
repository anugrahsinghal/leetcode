class Solution {
    public int trap(int[] height) {
        // 2 techniques
        // technique 1
        // 2pointer(harder intuition)
        // technique 2
        // min for each point and water stored
        // no need to calculate max water we only need max water at current point
        var maxToLeft = maxToLeft(height);
        var maxToRight = maxToRight(height);
        var minLR = minLR(maxToLeft, maxToRight, height);
        int water = 0;
        for(int i = 0; i < height.length; i++) { 
            water += Math.max(0, minLR[i] - height[i]);
        }
        return water;
    }
    int[] maxToLeft(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        res[0] = 0;
        for(int i = 1; i < n; i++) { 
            res[i] = Math.max(arr[i-1], res[i-1]);
        }
        System.out.println(Arrays.toString(res));
        return res;
    }
    int[] maxToRight(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        res[n-1] = 0;
        for(int i = n-2; i >= 0; i--) { 
            res[i] = Math.max(arr[i+1], res[i+1]);
        }
        System.out.println(Arrays.toString(res));
        return res;
    }
    int[] minLR(int[] left,int[]  right,int[]  arr) {
        int n = arr.length;
        int[] res = new int[n];
        for(int i = 0; i < n; i++) { 
            res[i] = Math.min(left[i], right[i]);
        }
        System.out.println(Arrays.toString(res));
        return res;
    }
}