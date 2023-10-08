class Solution {

    /*
        // [1,3] [2]
        // half = 2
        // numB = 0+1/2=0, numA = 2-0=2
        //   1,3|+INF
        //  -INF|2
        // --incrase numElementsB
        // numB = 1+1/2=1, numA = 2-1=1
        //    1 la | ra 3
        //    2 lb | rb +INF
    */
    public double findMedianSortedArrays(int[] a, int[] b) {
        var total = a.length + b.length;
        var half = (total + 1)/2;

        if(a.length < b.length) {
            return findMedianSortedArrays(b, a);
        }

        var bMinElements  = 0;
        var bMaxElements = b.length;
        // BINARY SEARCH OVER HOW MANY ELEMENTS OF B[] we will choose

        while(true) {
            int numElementsB = (bMinElements + bMaxElements) / 2;
            int numElementsA = half - numElementsB;

            // System.out.printf("bl = %d, br = %d, numB = %d, numA = %d\n", bleft, bright, numElementsB, numElementsA);

            var leftBIdx = numElementsB - 1;
            var leftAIdx = numElementsA - 1;

            var rightBIdx = numElementsB;
            var rightAIdx = numElementsA;

            var lbVal = leftBIdx >= 0 ? b[numElementsB - 1] : Integer.MIN_VALUE;
            var laVal = leftAIdx >= 0 ? a[numElementsA - 1] : Integer.MIN_VALUE;

            var rbVal = rightBIdx < b.length ? b[numElementsB] : Integer.MAX_VALUE;
            var raVal = rightAIdx < a.length ? a[numElementsA] : Integer.MAX_VALUE;

            // System.out.printf("LA = %d, LB = %d, RA = %d, RB = %d\n", laVal, lbVal, raVal, rbVal);

            // check in cross that left side both element are smaller
            if(lbVal <= raVal && laVal <= rbVal) {
                if(total % 2 == 1) {
                    return Math.max(lbVal, laVal);
                } else {
                    return (Math.max(laVal, lbVal) + Math.min(raVal, rbVal)) / 2.0;
                }
            } else if (lbVal > raVal) {
                bMaxElements = numElementsB - 1;
            } else if (laVal > rbVal) {
                bMinElements = numElementsB + 1;
            }

        }

    }
}