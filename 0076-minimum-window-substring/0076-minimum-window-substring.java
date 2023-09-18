class Solution {
    public String minWindow(String s, String t) {
      Map<Character, Integer> map = new HashMap<>();
      for(int i = 0; i < t.length(); i++) { 
        char c = t.charAt(i);
        map.put(c, map.getOrDefault(c, 0) + 1);
      }
      
      int i = 0, j = 0, min = Integer.MAX_VALUE;
      int uniqCount = map.size();
      String ans = "";
      while(j < s.length()) {
        char c = s.charAt(j);
        if(map.containsKey(c)) {
          map.put(c, map.get(c) - 1);
          if(map.get(c) == 0) {
            uniqCount--;
          }
        }
        // if valid string found
        if(uniqCount == 0) {// increment I till we make smallest substring
          while(uniqCount == 0 && i <= j) {
            if(j-i+1 < min) {
              min = j - i + 1;
              ans = s.substring(i, j+1);
            }
            char start = s.charAt(i);
            if(map.containsKey(start)) {
              map.put(start, map.get(start) + 1);
              if(map.get(start) == 1) {
                uniqCount++;
              }
            }
            i++;
          }
        }

        j++;
      }

      return ans;
    }
}