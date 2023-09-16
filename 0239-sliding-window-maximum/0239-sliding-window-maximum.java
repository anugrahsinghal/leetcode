class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        List <Integer> ans = max_of_subarrays(nums, N, k);
        System.out.println(ans);
        int[] arr = new int[N-k+1];
        for(int i = 0; i < N-k+1; i++) { 
          arr[i] = ans.get(i);
        }
        return arr;//ans.toArray(new int[0]);
    }

    static ArrayList <Integer> max_of_subarrays(int arr[], int N, int K) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        // addLast - to add at last
        // poll to remove at front
        // peek to view at front
        // to view at back ? -- peekLast
        ArrayList<Integer> max = new ArrayList<>();
        int i = 0, j = 0;
        while(j < N) {
            int curr = arr[j];
            // 10,7,9,4 case in example 2
            while(!dq.isEmpty() && curr > dq.peekLast()) {
                dq.removeLast(); // remove at front
            }
            //dq.addLast
            dq.addLast(curr);
            int ws = j - i + 1;
            if(ws < K) {
                j++;
            } else {
                max.add(dq.peek()); // peek shows top
                if(dq.peek() == arr[i]) {
                    dq.removeFirst();
                }
                i++;
                j++;
            }
        }
        
        return max;
    }
}