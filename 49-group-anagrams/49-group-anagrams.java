class Solution {
    public List<List<String>> groupAnagrams(final String[] strs) {
        final Map<String, List<String>> map = new HashMap<>();
        final int[] count = new int[26];
        for(var origStr : strs) {
            final char[] arr = origStr.toCharArray();
            Arrays.fill(count, 0);
            
            for(char c : arr) {
                count[c - 'a']++;
            }
            final var sb = new StringBuilder();
            
            for(int c : count) {
                sb.append(c).append("#");
            }
            
            final var str = sb.toString();
            
            map.putIfAbsent(str, new ArrayList<>());
            map.get(str).add(origStr);
        }
        
        return new ArrayList<>(map.values());
    }
}


