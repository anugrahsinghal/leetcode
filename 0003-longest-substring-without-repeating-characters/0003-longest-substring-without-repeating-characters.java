class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, N = s.length();
        int uniqCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        while(j < N) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);

            int ws = j - i + 1;

            if(map.size() == ws) { // everything is uniq
                max = Math.max(max, map.size());
                j++;
            } else if (ws > map.size()){
                // calc ws everytime since `i` is getting updated 
                while((j - i + 1) > map.size()) {
                    char c_i = s.charAt(i);
                    if(map.containsKey(c_i)) {
                        map.put(c_i, map.get(c_i) - 1);
                        if(map.get(c_i) == 0) {
                            map.remove(c_i);
                        }
                    }
                    i++;
                }
                j++;
            }

            // if(!map.containsKey(c)) {
            //     map.put(c, 1);
            //     // calculate max chars
            //     max = Math.max(max, map.size());
            //     // System.out.println(map);
            // } else {
            //     map.put(c, map.get(c) + 1); // >= 2 always if 
            //     while(1 != map.get(c)) {
            //         char c_i = s.charAt(i);
            //         if(map.containsKey(c_i)) {
            //             map.put(c_i, map.get(c_i) - 1);
            //             if(map.get(c_i) == 0) {
            //                 map.remove(c_i);
            //             }
            //         }
            //         i++;
            //     }
            // }
            // j++;
        }
        return max;
    }
}