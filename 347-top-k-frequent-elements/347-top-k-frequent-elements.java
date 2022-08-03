/*Generics
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        PriorityQueue<Pair<Integer,Integer>> MIN_HEAP = 
            new PriorityQueue<>(Comparator.comparing(Pair<Integer,Integer>::value));
        
        map.forEach((key,v) -> {
            MIN_HEAP.offer(new Pair<>(key, v));
            if(MIN_HEAP.size() > k) {
                MIN_HEAP.poll();
            }
        }
        );
        
        
        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = MIN_HEAP.poll().key();
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
*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // number, freq
        Map<Integer,Integer> freq = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1,p2) -> p1.freq - p2.freq);
        
        for(Map.Entry<Integer,Integer> entry : freq.entrySet()) {
            int number = entry.getKey();
            int _freq = entry.getValue();
            
            minHeap.add(new Pair(number, _freq));
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        // System.out.println(minHeap);
        
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = minHeap.poll().elem;
        }
        
        return res;
    }
    
    static class Pair {
         int elem;
         int freq;
         Pair(int e, int i) {
               elem = e;
               freq = i;
               // System.out.printf("e %d - freq %d\n",elem,freq);
         }
        
        public String toString() {
            return String.format("e %d - freq %d\n",elem,freq);
        }
    }
}