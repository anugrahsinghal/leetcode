class Solution {
    public List<List<String>> groupAnagrams(final String[] strs) {
        
        final Map<String, List<String>> map = new HashMap<>();
        
        for(var origStr : strs) {
            final char[] arr = origStr.toCharArray();
            final char[] count = new char[26];
            
            for(char c : arr) {
                count[c - 'a']++;
            }
            
            final var str = new String(count);
            
            map.putIfAbsent(str, new ArrayList<>());

            map.get(str).add(origStr);
        }
        
        return new ArrayList<>(map.values());
    }
}


