class Solution {
    public int characterReplacement(String s, int k) {
        int tempk = k;
        Map<Character, Integer> freq = new HashMap<>();
        int i = 0, j = 0, max = 0;
        int N = s.length();
        int len = 0;
        while(j < N) {
            char c = s.charAt(j);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            var ws = j-i+1;
            if(ws-maxVal(freq) <= k) {
                len = Math.max(len, ws);
            } else {
                while(((j-i+1) - maxVal(freq)) > k) {
                    var ci = s.charAt(i);
                    freq.put(ci, freq.get(ci) - 1);
                    i++;
                }
            }
            j++;
        }
        return len;
    }
    int maxVal(Map<Character, Integer> freq) {
        int max = 0;
        for(var k : freq.keySet()) {
            max = Math.max(max, freq.get(k));
        }
        // System.out.printf("max=%d--map[%s]\n",max,freq);
        return max;
    }
}