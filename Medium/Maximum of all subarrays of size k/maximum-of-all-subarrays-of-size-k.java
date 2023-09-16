//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])
    {
        //taking input using class Scanner
        Scanner sc = new Scanner(System.in);
        
        //taking total count of testcases
        int t = sc.nextInt();
        
        
        
        while(t-- > 0)
        {
            //taking total number of elements
            int n = sc.nextInt();
            
            //taking size of subArrays 
            int k = sc.nextInt();
            
            //Declaring and Intializing an array of size n
            int arr[] = new int[n];
            
            //adding all the elements to the array 
            for(int i = 0; i <n; i++)
            {
                arr[i] =sc.nextInt();
            }
            
            //Calling the method max_of_subarrays of class solve
            //and storing the result in an ArrayList
            ArrayList <Integer> res = new Solution().max_of_subarrays(arr, n, k);
            
            //printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int N, int K) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        // addLast - to add at last
        // poll to remove at front
        // peek to view at front
        // to view at back ? -- peekLast
        ArrayList<Integer> max = new ArrayList<>();
        int i = 0, j = 0;
        while(j < N) {
            int curr = arr[j];
            // 10,7,9,4 case in example 2
            while(!dq.isEmpty() && curr > dq.peekLast()) {
                dq.removeLast(); // remove at front
            }
            //dq.addLast
            dq.addLast(curr);
            int ws = j - i + 1;
            if(ws < K) {
                j++;
            } else {
                max.add(dq.peek()); // peek shows top
                if(dq.peek() == arr[i]) {
                    dq.removeFirst();
                }
                i++;
                j++;
            }
        }
        
        return max;
    }
}