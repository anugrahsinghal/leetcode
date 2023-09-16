//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        Map<Character, Integer> pFreq = freq(pat);
        Map<Character, Integer> freq = new HashMap<>();
        Map<Character, Integer> map = pFreq;
        int i = 0, j = 0, ans = 0;
        int K = pat.length();
        int uniqCount = pFreq.size();
        while(j < txt.length()) {
            char c = txt.charAt(j);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) {
                    uniqCount--;
                }
            }
            int ws = j - i + 1;
            if(ws < K) {
                j++;
            } else {
                if(uniqCount == 0) { ans++; }
                char ci = txt.charAt(i);
                if(map.containsKey(ci)) {
                    map.put(ci, map.get(ci) + 1);
                    if(map.get(ci) == 1) {
                        uniqCount++;
                    }
                }
                i++;
                j++;
            }
        }
        // while(j < txt.length()) {
        //     char c = txt.charAt(j);
        //     freq.put(c, freq.getOrDefault(c, 0) + 1);
        //     // if(freq.get(c) == pFreq.get(c)) {
        //     //     uniqCount++;
        //     // }
        //     int ws = j - i + 1;
        //     if(ws < K) {
        //         j++;
        //     } else {
        //         // if(uniqCount == pFreq.size()) {
        //         //     ans++;
        //         // }
        //         // freq.put(txt.charAt(i) , freq.get(txt.charAt(i)) - 1); // 0 as default
        //         // // in old code when character is again added to set
        //         // // we increase uniq count
        //         // if(freq.get(txt.charAt(i)) == 0) {
        //         //     freq.remove(txt.charAt(i));
        //         //     uniqCount--;
        //         // }
        //         boolean isEqual = sameFreq(pFreq, freq);
        //         if(isEqual) {
        //             ans++;
        //         }
        //         freq.put(txt.charAt(i) , freq.get(txt.charAt(i)) - 1); // 0 as default
        //         // in old code when character is again added to set
        //         // we increase uniq count
        //         if(freq.get(txt.charAt(i)) == 0) {
        //             freq.remove(txt.charAt(i));
        //             uniqCount--;
        //         }
                
        //         i++;
        //         j++;
        //     }
        // }
        return ans;
    }
    
    boolean sameFreq(Map<Character, Integer> pFreq, Map<Character, Integer> freq) {
        if(freq.size() != pFreq.size()) return false;
        
        for(Map.Entry<Character, Integer> e : pFreq.entrySet()) {
            if(e.getValue() != freq.get(e.getKey())) {
                return false;
            }
        }
        return true;
    }
    
    Map<Character, Integer> freq(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) { 
            map.put(s.charAt(i) , map.getOrDefault(s.charAt(i), 0) + 1);
        }
        return map;
    }
}