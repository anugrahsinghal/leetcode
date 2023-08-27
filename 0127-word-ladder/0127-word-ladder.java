class Solution {
    // something like shortest path finding - USE BFS for shortest path type problems
    public int ladderLength(String beginWord, String endWord, List<String> w) {
        Set<String> wordList = new HashSet<>(w);
        
        Map<Integer, Set<Character>> charsForPosition = new HashMap<>();
        for(var word : wordList) {
            for(int i = 0; i < beginWord.length(); i++) {
                if(charsForPosition.get(i) == null) {
                    charsForPosition.put(i, new LinkedHashSet<>());
                }
                charsForPosition.get(i).add(word.charAt(i));
            }
        }        
        
        int cost = Integer.MAX_VALUE;
        Queue<Pair<String, Integer>> q = new ArrayDeque<>();
        
        q.add(new Pair(beginWord, 1));
        wordList.remove(beginWord);

        while(!q.isEmpty()) {
            var pair = q.poll();
            
            var word = pair.key;
            var level = pair.value;

            if(word.equals(endWord)) {
                cost = Math.min(cost, level);
            }

            char[] currentWord = word.toCharArray();
            for(int position = 0; position < currentWord.length; position++) { 
                char originalChar = currentWord[position];
                for(char replacement : charsForPosition.get(position)) {
                    currentWord[position] = replacement;
                    var newWord = new String(currentWord);
                    if(wordList.contains(newWord)) {
                        q.add(new Pair<>(newWord, level+1));
                        wordList.remove(newWord); 
                        // important to mark visited in loop itself 
                        // else BFS edge cases you will have to debug
                    } 
                }
                currentWord[position] = originalChar;
            }
        }
        
        return cost == Integer.MAX_VALUE ? 0 : cost;
    }

static class Pair<K,V> {
    K key;
    V value;
    Pair(K k, V v) {
        key = k;
        value = v;
    }
    public K key() {
        return key;
    }
    public V value() {
        return value;
    }
    public boolean equals(Object _o) {
        Pair<K, V> o = (Pair<K, V>) _o;
        return this.key.equals(o.key) && this.value.equals(o.value);
    }
    public int hashCode() {
        return Objects.hash(key, value);
    }
}

    // IDK WHY THIS DID NOT WORK :(
    boolean doDFS(
        char[] currentWord, String target, 
        Map<Integer, Set<Character>> charsForPosition,
        int currCost,
        int[] cost,
        Set<String> wordList,
        int minIdx,
        Set<String> visited
    ) {
        var currWordStr = new String(currentWord);
        System.out.println(currWordStr);
        if(currWordStr.equals(target)) {
            cost[0] = Math.min(cost[0], currCost);
            System.out.println("cost -- " + cost[0] + " -- currCost " + currCost);
            return true;
        }
        if(visited.contains(currWordStr)) { return false; } // already visited in recursion

        visited.add(currWordStr);

        for(int replaceIndex = 0; replaceIndex < currentWord.length; replaceIndex++) { 
            char originalChar = currentWord[replaceIndex];

            // for(int i = 0; i < wordList.size(); i++) { 
                // char replacement = wordList.get(i).charAt(replaceIndex);
            for(var word : wordList) { 
                char replacement = word.charAt(replaceIndex);
                if(replacement == originalChar) continue; // no meaning replacing same char
                currentWord[replaceIndex] = replacement;
                
                var newWord = new String(currentWord);
                if(wordList.contains(newWord) == false) {
                    currentWord[replaceIndex] = originalChar; // revert change
                    continue;// dont recur for invalid entry
                }
                if(visited.contains(newWord)) {
                    currentWord[replaceIndex] = originalChar; // revert change
                    continue;// dont recur for invalid entry
                }
                boolean val = 
                  doDFS(currentWord, target, charsForPosition, currCost + 1, cost, wordList, 0+1, visited);// i+1
                currentWord[replaceIndex] = originalChar;
                if(val) return true;
                else continue;
            }
        }

        return false;

    }
}