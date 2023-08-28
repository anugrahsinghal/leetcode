class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // for a single dist - only single node present
        // closest -> smallest -> maxHeap
        var pq = new PriorityQueue<Pair<Integer, Integer>>(
            (p1, p2) -> {
                return distanceFromOrigin(p2) - distanceFromOrigin(p1);
            }
        );
        for(int i = 0; i < points.length; i++) { 
            var point = new Pair<Integer, Integer>(points[i][0], points[i][1]);
            pq.add(point);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        // System.out.println(pq);
        var ans = new int[pq.size()][2];
        int c = 0;
        while(!pq.isEmpty()) {
            var p = pq.poll();
            ans[c++] = new int[]{p.key, p.value};
        }

        return ans;
    }

    // no need to take square or square root
    // that is the trick to this question
    int distanceFromOrigin(Pair<Integer, Integer> p2){
        return (int) (Math.pow((0 - p2.key),2) + Math.pow((0 - p2.value),2));
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
    public String toString() {
        return "key = " + key + "-value = " + value;
    }
}

}