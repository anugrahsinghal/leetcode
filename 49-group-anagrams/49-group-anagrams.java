class Solution {
    public List<List<String>> groupAnagrams(final String[] strs) {
        
        final Map<String, List<String>> map = new HashMap<>();
        
        for(var origStr : strs) {
            final char[] arr = origStr.toCharArray();
            Arrays.sort(arr);
            
            final var str = new String(arr);
            
            map.putIfAbsent(str, new ArrayList<>());

            map.get(str).add(origStr);
        }
        
        return new ArrayList<>(map.values());
    }
}


