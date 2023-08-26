// SOURCE - https://practice.geeksforgeeks.org/problems/alien-dictionary/1
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;
//User function Template for Java

class Solution
{
    public String findOrder(String [] words, int N, int K) {
        // Write your code here
        // how to create the graph from the string is the question right now

        // pair of 2 strings
        // till character match - no edge
        // as soon as mismatch
        // directed edge from c1 to c2
        Map<Character, List<Character>> g = new HashMap<>();
        for(char c = 'a'; c <= 'z'; c++) { // GFG specific optimization
            if(K == 0) break;
            g.put(c, new ArrayList<>());
            K--;
        }
        int i = 0;
        int j = 1;
        while(i < j && j < words.length) {
            char[] w1 = words[i].toCharArray();
            char[] w2 = words[j].toCharArray();
            // for(char c : w1) {
            //     if(g.get(c) == null) {
            //         g.put(c, new ArrayList<>());
            //     }
            // }
            // for(char c : w2) {
            //     if(g.get(c) == null) {
            //         g.put(c, new ArrayList<>());
            //     }
            // }
            i++;
            j++;
            // compare
            int k = 0;
            while(k < Math.min(w1.length, w2.length)) {
                if(w1[k] != w2[k]) {
                    g.get(w1[k]).add(w2[k]);
                    break;
                } else {
                    k++;
                }
            }
            
        }
        // PriortyQueue<Character> pq = new PriorityQueue<>();
        // System.err.println(g);
        
        var chars = g.keySet();

        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> visited = new HashMap<>();

        for(Character c : chars) {
            if(chars.contains(c) && visited.get(c) == null) {
                boolean val = toposort(g, c, stack, visited);
                if(val == false) {
                    // System.err.println("no-valid-order");
                    // System.err.println(stack);
                    // System.err.println((visited));
                    return "";
                }
            }
        }

        // System.out.println(stack);
        // System.out.println((visited));
        
        // System.out.println(stack);

        String ans = "";
        while(stack.size() > 0) {
            ans += stack.pop();// + ans;
        }
        // System.out.println(ans);

        return ans;
    }
    // is this like topo sort ?

    boolean toposort(
        Map<Character, List<Character>> g, 
        Character node, 
        Stack<Character> stack, 
        Map<Character, Integer> visited /*3 state*/
    ) {
        // System.err.println("calling for = " + node + " -- nbr = " + g.getOrDefault(node, new ArrayList<>()));
        visited.put(node, 1);

        for(Character nbr: g.getOrDefault(node, new ArrayList<>())) {
            if(visited.get(nbr) == null) { // unvisited
                if(toposort(g, nbr, stack, visited) == false) {
                    // System.err.println("toposort fail");
                    return false;
                }
            } else if(visited.get(nbr) == 1) { // missed this - was doing visited.get(node) here
                // System.err.println("loop fail");
                return false;// loop found
            }
        }
        
        // System.err.println("pushing = " + node);
        visited.put(node, 2);
        stack.push(node);

        return true;
    }
}


//{ Driver Code Starts

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends
