//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        int i = 0;
        int j = 0;
        long sum = 0;
        long maxS = Integer.MIN_VALUE;
        while(j < N) {
            sum = sum + Arr.get(j);
            int ws = j - i + 1;
            if(ws < K) {
                j++;
            } else { // ws == K
                maxS = Math.max(sum, maxS);
                sum = sum - Arr.get(i);
                i++;
                j++;
            }
        }
        
        return maxS;
    }
}