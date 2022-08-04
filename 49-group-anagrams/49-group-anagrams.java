class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(var origStr : strs) {
            char[] arr = origStr.toCharArray();
            Arrays.sort(arr);
            var str = new String(arr);
            if(map.get(str) == null) {
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(origStr);
        }
        
        return new ArrayList<>(map.values());
    }
}