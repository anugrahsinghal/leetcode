class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // use max-PQ
        // pop K times
        // nlogn
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        PriorityQueue<Pair<Integer,Integer>> pq = 
            new PriorityQueue<>(Comparator.comparing(Pair<Integer,Integer>::value).reversed());
        
        map.forEach((key,v) -> pq.offer(new Pair<>(key, v)));
        
        
        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = pq.poll().key();
        }
        
        return ans;
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
}


}