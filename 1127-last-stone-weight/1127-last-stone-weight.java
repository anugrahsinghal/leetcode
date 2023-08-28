class Solution {
    public int lastStoneWeight(int[] stones) {
        var pq = new PriorityQueue<Integer>((a,b) -> (b-a));
        for(int s : stones) { pq.add(s); }

        while(pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if(a!=b) {
                pq.add(Math.abs(b-a));
            }
        }
        // at most 1 stone left
        if(pq.isEmpty()) return 0;
        return pq.poll();
    }
}