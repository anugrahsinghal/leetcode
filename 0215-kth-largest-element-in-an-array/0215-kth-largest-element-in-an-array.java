class Solution {
    public int findKthLargest(int[] nums, int k) {
        var pq = new PriorityQueue<Integer>(); // min heap
        for(int num : nums) {
            pq.add(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}