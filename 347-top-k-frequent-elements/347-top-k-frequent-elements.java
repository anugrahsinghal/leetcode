class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
//         PriorityQueue<Pair<Integer,Integer>> MIN_HEAP = 
//             new PriorityQueue<>(Comparator.comparing(Pair<Integer,Integer>::value));
        
//         map.forEach((key,v) -> {
//             MIN_HEAP.offer(new Pair<>(key, v));
//             if(MIN_HEAP.size() > k) {
//                 MIN_HEAP.poll();
//             }
//         }
//         );
        
        
//         int[] ans = new int[k];
//         for(int i = 0; i < k; i++) {
//             ans[i] = MIN_HEAP.poll().key();
//         }
        
//         return ans;
        
        // technique 2
        // bucket sort
        // map count to int[]
        // how many numbers have that particular count
        
//         Map<Integer/*Count*/, List<Integer>> countToElements = 
//             new TreeMap<>((i1,i2) -> i2-i1);// tree map keys are sorted right ?
        
        
//         map.forEach((key,v) -> {
//             List<Integer> list = countToElements.getOrDefault(v, new ArrayList<Integer>());
//             list.add(key);
//             countToElements.put(v, list);
//         });
        
//         int[] ans = new int[k];
//         int i = 0;
//         for(int count : countToElements.keySet()) {
//             var v = countToElements.get(count);
//             // works because number of elements satisfying K cannot be ambiguous
//             // meaning only k uniq element will be there satisfying the criteria
//             for(var item : v) {
//                 ans[i++] = item;
//             }
//             if( i == k) break;
//         }

//         return ans;      
        
        
        // try 3
        // map is not needed
        // result is bound by size of input
        // so we can have a List<List<int>> the number of list<int> = n
        
        List<List<Integer>> buckets = new ArrayList<>();
        for(int i = 0; i < n+1; i++) {
            buckets.add(new ArrayList<>());
        }
        
        map.forEach((key,freq) -> {
            // get bucket for count v
            // add element key to that bucket
            var bucket = buckets.get(freq);
            bucket.add(key);
        });
        
        int[] ans = new int[k];
        int i = 0;
        // bcoz 1 can be the min freq for an element
        for(int count = n; count >= 1; count--) {
            var v = buckets.get(count);
            // works because number of elements satisfying K cannot be ambiguous
            // meaning only k uniq element will be there satisfying the criteria
            for(var item : v) {
                ans[i++] = item;
            }
            if(i == k) return ans;
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