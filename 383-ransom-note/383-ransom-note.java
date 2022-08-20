class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) return false;
        // does magazine have equal letters as ransom-note
        var map = freqArr(magazine);
        var n = ransomNote.length();
        for(int i = 0; i < n; i++) {
            char c = ransomNote.charAt(i);
            map[c - 'a']--;
            if(map[c - 'a'] < 0) return false;
        }
        
        return true;
    }
    
    int[] freqArr(String s) {
        int[] arr = new int[26];
        var n = s.length();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            arr[c - 'a']++;
        }
        
        return arr;
    }
    
}