class Solution {
    public int largestRectangleArea(int[] heights) {
        // for each index try the next greater to right and calc area
        // for each index try the next greater to left and calc area
        // and also area of each node or for where next is -1
        // System.out.println(Arrays.toString(nextSmallestToRight(heights)));
        // System.out.println(Arrays.toString(nextSmallestToLeft(heights)));
        var h = heights;
        var maxH = 0;
        var n = h.length;
        var nsr = nextSmallestToRight(heights);
        var nsl = nextSmallestToLeft(heights);
        for(int i = 0; i < n; i++) { 
            maxH = Math.max(maxH, (nsr[i] - nsl[i] - 1) * heights[i]);
            // var currH = h[i];
            // maxH = Math.max(maxH, currH);

            // if(ngl[i] != -1) {
            //     var leftHighestIdx = ngl[i];
            //     var leftDist = i - leftHighestIdx + 1;
            //     var leftH = leftDist * Math.min(currH, h[leftHighestIdx]);
            //     System.out.printf("L-Dist %d - %d = %d || H = %d \n", i, leftHighestIdx, leftDist, leftH);
            //     maxH = Math.max(maxH, leftH);
            // }
            // if(ngr[i] != -1) {
            //     var rightHighestIdx = ngr[i];
            //     var rightDist = rightHighestIdx - i + 1;
            //     var rightH = rightDist * Math.min(currH, h[rightHighestIdx]);
            //     System.out.printf("R-Dist %d - %d = %d || H = %d \n", rightHighestIdx, i,rightDist, rightH);
            //     maxH = Math.max(maxH, rightH);
            // }

            // int width = 0;
            // if(ngr[i] != -1) {
            //     width = ngr[i] - i;
            // }
            // if(ngl[i] != -1) {
            //     width = Math.max(width, i - ngl[i]);
            // }

            // maxH = Math.max(maxH, (width + 1) * currH);
        }

        return maxH;
    }
/*
idx=[0,1,2,3,4,5]
    [2,1,5,6,2,3]
ngr=[2,2,3,-1,5,-1]
*/
    int[] nextGreaterToRight(int[] arr) {
        Stack<Pair<Integer,Integer>> st = new Stack<>();
        int n = arr.length;
        int[] ngr = new int[n];
        for(int i = n-1; i >= 0; i--) { 
            while(!st.isEmpty() && st.peek().key/*value*/ <= arr[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                ngr[i] = -1;
            } else {
                ngr[i] = st.peek().value;// index
            }
            st.push(new Pair(arr[i], i));
        }
        return ngr;
    }


/*
idx=[0,1,2,3,4,5]
    [2,1,5,6,2,3]
ngl=[-1,0,-1,-1,3,3]
*/

    int[] nextGreaterToLeft(int[] arr) {
        Stack<Pair<Integer,Integer>> st = new Stack<>();
        int n = arr.length;
        int[] ngl = new int[n];
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && st.peek().key/*value*/ <= arr[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                ngl[i] = -1;
            } else {
                ngl[i] = st.peek().value;// index
            }
            st.push(new Pair(arr[i], i));
        }
        return ngl;
    }

    int[] nextSmallestToLeft(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Pair<Integer,Integer>> st = new Stack<>();
        // key = elem
        // value = index
        for(int i = 0; i < n; i++) { 
            while(!st.isEmpty() && st.peek().key >= arr[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = st.peek().value;
            }
            st.push(new Pair<>(arr[i], i));
        }
        return res;
    }
    int[] nextSmallestToRight(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Pair<Integer,Integer>> st = new Stack<>();
        // key = elem
        // value = index
        for(int i = n-1; i >= 0; i--) { 
            while(!st.isEmpty() && st.peek().key >= arr[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                res[i] = n;
            } else {
                res[i] = st.peek().value;
            }
            st.push(new Pair<>(arr[i], i));
        }
        return res;
    }

static class Pair<K,V> {
    K key;
    V value;
    Pair(K k, V v) {
        key = k;
        value = v;
    }
    public K key() {
        return key;
    }
    public V value() {
        return value;
    }
    public boolean equals(Object _o) {
        Pair<K, V> o = (Pair<K, V>) _o;
        return this.key.equals(o.key) && this.value.equals(o.value);
    }
    public int hashCode() {
        return Objects.hash(key, value);
    }
}

}

