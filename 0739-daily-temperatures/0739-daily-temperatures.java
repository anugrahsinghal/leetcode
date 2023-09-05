class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //                       [0, 1, 2, 3, 4, 5, 6, 7 ] 
        // Input: temperatures = [73,74,75,71,69,72,76,73]
        // Output:               [1,1,4,2,1,1,0,0]
        // NGtR
        // ELEMENT,INDEX
        
        Stack<Pair<Integer,Integer>> st = new Stack<>();
        var arr = temperatures;
        int n = arr.length;
        int[] ngr = new int[n];

        for(int i = n-1;i >= 0; i--) {
            while(!st.isEmpty() && st.peek().key/*element*/  <= arr[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                ngr[i] = -1;
            } else {
                ngr[i] = st.peek().value;// index
            }
            st.push(new Pair(arr[i], i));
        }
        // System.out.println(st);
        // st.forEach(i -> System.out.println("elem ");)
        // [89,62,70,58,47,47,46,76,100,70]
        // [0, 1, 2, 3, 4, 5, 6, 7, 8,  9 ]
        // [8, 2, 7, 7, 5, 7, 7, 8, -1, -1]

        // System.out.println("NGR = " + Arrays.toString(ngr));
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) { 
            if(ngr[i] == -1) {
                ngr[i] = 0;
            } else {
                ngr[i] = ngr[i] - i;
            }
            // if(ngr[i] == -1) {
            //     ans[i] = 0;
            // } else {
            //     ans[i] = ngr[i] - i;
            // }
        }
        // System.out.println(Arrays.toString(ans));
        // return ans;
        return ngr;
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