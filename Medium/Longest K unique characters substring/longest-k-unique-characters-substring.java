//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int K) {
        
        int i = 0, j = 0, N = s.length();
        int uniqCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = -1;
        while(j < N) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);

            int ws = j - i + 1;
            if(map.size() < K) {
                j++;
            } else if(map.size() == K) { // everything is uniq
                max = Math.max(max, ws);
                j++;
            } else if (map.size() > K){
                // calc ws everytime since `i` is getting updated 
                while(map.size() > K && i <= j) {
                    char c_i = s.charAt(i);
                    if(map.containsKey(c_i)) {
                        map.put(c_i, map.get(c_i) - 1);
                        if(map.get(c_i) == 0) {
                            map.remove(c_i);
                        }
                    }
                    i++;
                }
                j++;
            }

        }
        return max;
    }
}