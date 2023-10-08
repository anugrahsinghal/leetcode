class TimeMap {
    Map<String, List<Pair<String, Integer>>> map;// = new HashMap<>();
    public TimeMap() {
        map = new HashMap<>();
    }
    public void set(String key, String value, int timestamp) {
        if(map.get(key) == null) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        // nearest lower value with binary search
        List<Pair<String, Integer>> arr = map.get(key);
        if(arr == null) return "";
        // System.out.println("Get at TS = " + timestamp + arr);
        
        var low = 0;
        var high = arr.size() - 1;
        var ansIdx = -1;// start index

        while(low <= high) {
            var mid = (high+low) >>> 1;
            // System.out.printf("L = %d, H = %d, mid = %d\n",low,high,mid);
            var midVal = arr.get(mid).value; // something with mid
            if(midVal <= timestamp) {
                ansIdx = mid;
                // reduce search space
                // since we need to find larger value
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if(ansIdx == -1) {
            return "";
        }

        return arr.get(ansIdx).key; // something with mid;
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
        return "TS = " + value + " value = " + key ;
    }
}
}
