class KthLargest {

    // MIN HEAP
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->  (a - b));
    int K;

    public KthLargest(int k, int[] nums) {
        this.K = k;
        // for max Q use min heap
        // for min Q use max heap
        for(int num : nums) {
            pq.offer(num);
        }

        while (pq.size() > k) {
            pq.poll();
        }
    }
    
    public int add(int num) {
        pq.offer(num);
        if(pq.size() > K) {
            pq.poll();
        }
        
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */