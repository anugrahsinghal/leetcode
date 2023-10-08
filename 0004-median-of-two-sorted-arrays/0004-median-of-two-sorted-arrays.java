class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        var total = nums1.length + nums2.length;
        var half = (total + 1)/2;

        int[] a;
        int[] b;
        if(nums1.length > nums2.length) {
            a = nums1;
            b = nums2;
        } else {
            b = nums1;
            a = nums2;
        }

        var bleft  = 0;
        var bright = b.length;

        // var aleft  = 0;
        // var aright = a.length - 1;
        // System.out.println((int)Math.ceil(-1/(double)2));
        
        while(true) {
            int numElementsB = (bleft + bright) / 2;// elements b4 mid are chosen
            // System.out.printf("bl = %d, br = %d, numEle = %d\n", bleft, bright, numElementsB);

            int numElementsA = half - numElementsB;

            // System.out.printf("bl = %d, br = %d, numB = %d, numA = %d\n", bleft, bright, numElementsB, numElementsA);
            // [1,3] [2]
            // half = 2
            // numB = 0+1/2=0, numA = 2-0=2
            //   1,3|+INF
            //  -INF|2
            // --incrase numElementsB
            // numB = 1+1/2=1, numA = 2-1=1
            //    1 |3
            //    2 |+INF

            // 1,2 la | ra 3,4 
            //   5 lb | rb 6
            var lb = numElementsB - 1;
            var la = numElementsA - 1;

            var rb = numElementsB;
            var ra = numElementsA;

            var lbVal = numElementsB - 1 >= 0 ? b[numElementsB - 1] : Integer.MIN_VALUE;
            var laVal = numElementsA - 1 >= 0 ? a[numElementsA - 1] : Integer.MIN_VALUE;

            var rbVal = numElementsB < b.length ? b[numElementsB] : Integer.MAX_VALUE;
            var raVal = numElementsA < a.length ? a[numElementsA] : Integer.MAX_VALUE;

            // System.out.printf("LA = %d, LB = %d, RA = %d, RB = %d\n", laVal, lbVal, raVal, rbVal);

            if(lbVal <= raVal && laVal <= rbVal) {
                if(total % 2 == 1) {//odd
                    return Math.max(lbVal, laVal);
                } else {
                    return (Math.max(laVal, lbVal) + Math.min(raVal, rbVal)) / 2.0;
                }
            } else if (lbVal > raVal) {
                bright = numElementsB-1;
            } else if (laVal > rbVal) {
                bleft = numElementsB+1;
            }

        }

    }
}