class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        var s1 = s.toCharArray();
        Arrays.sort(s1);
        
        var s2 = t.toCharArray();
        Arrays.sort(s2);
        
        // for(int i = 0; i < s.length(); i++) {
        //     if(s1[i] != s2[i])
        //         return false;
        // }
        
        return Arrays.equals(s1, s2);
    }
}