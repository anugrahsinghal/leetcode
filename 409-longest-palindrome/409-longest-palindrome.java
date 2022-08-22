class Solution {
    public int longestPalindrome(String s) {
        // abccccdd
        // b
        // -> dccaccd
        /*
        exhaust even letters
        exhaust letters with freq >= 2
        [26]a-z
        [26]A-Z
        
        */
        Map<Character, Integer> map = new HashMap<>(60);
        
        var arr = s.toCharArray();
        int len = 0;
        for(char c : arr) {
            if(map.get(c) == null) {
                map.put(c, 1);
            } else {
                // if already present then we know freq = 1
                len += 2;
                map.remove(c);
            }
        }
        
        if(!map.isEmpty()) return len + 1;
        return len;
    }
    
    
}