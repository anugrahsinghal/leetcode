class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) return false;
        // does magazine have equal letters as ransom-note
        var map = freqMap(magazine);
        var n = ransomNote.length();
        for(int i = 0; i < n; i++) {
            char c = ransomNote.charAt(i);
            map.put(c, map.getOrDefault(c, 0) - 1);
            if(map.get(c) < 0) {
                return false;
            }
        }
        
        return true;
        
        
        
//         var note = freqMap(ransomNote);
//         if(note.size() > mag.size()) return false;
        
//         for(Character letter : note.keySet()) {
//             int freq = note.get(letter);
            
//             Integer magFreq = mag.get(letter);
//             if(magFreq == null || magFreq < freq) {
//                 return false;
//             }
//         }
        
//         return true;
    }
    
    Map<Character, Integer> freqMap(String s) {
        var n = s.length();
        var map = new HashMap<Character, Integer>();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        return map;
    }
}