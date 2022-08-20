class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) return false;
        // does magazine have equal letters as ransom-note
        var map = freqMap(magazine);
        var n = ransomNote.length();
        for(int i = 0; i < n; i++) {
            char c = ransomNote.charAt(i);
            var freq = map.get(c);
            if(freq == null || freq <= 0) return false;
            map.put(c, freq - 1);
        }
        
        return true;
    }
    
    Map<Character, Integer> freqMap(String s) {
        var n = s.length();
        var map = new HashMap<Character, Integer>(26);
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        return map;
    }
}