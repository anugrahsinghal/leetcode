//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int K){
        Boolean[][] dp = new Boolean[N+1][K+1];
        return helper(N-1, K, arr, dp);
    }
    
    static boolean helper(int idx, int target, int[] arr, Boolean[][] dp) {
        if(target == 0) return true;
        if(target < 0 || idx < 0) return false;
        if(dp[idx][target] != null) return dp[idx][target];
        
        
        boolean pick = helper(idx-1, target-arr[idx], arr, dp);
        boolean notPick = helper(idx-1, target, arr, dp);
        
        dp[idx][target] = (pick || notPick);
        
        return dp[idx][target];
    }
}