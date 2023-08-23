/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // normally works
    // But Follow up: ??
    //   If the BST is modified often (i.e., we can do insert and delete operations) 
    //   and you need to find the kth smallest frequently, how would you optimize?


    public int kthSmallest(TreeNode root, int k) {
        int[] count = new int[]{0};
        int[] ans = new int[1];
        inOrder(root, count, ans, k);
        
        return ans[0];
    }

    public void inOrder(TreeNode node, int[] count, int[] ans, int k) {
        if(node == null) return;

        inOrder(node.left, count, ans, k);
        
        count[0]++;
        if(count[0] == k) {
            ans[0] = node.val;
            return;// no need to do more recursion
        }

        inOrder(node.right, count, ans, k);
    }
}