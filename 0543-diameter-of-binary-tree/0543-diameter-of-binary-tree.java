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
    // the catch here is that
    // inside a subtree itself can be the max diameter
    // so it is not left + right
    // so we need to find max at each node
    // and store max
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        max[0] = 0;

        int left = maxDepth(root.left, max);
        int right = maxDepth(root.right, max);
        if((left+right) > max[0]) {
            max[0] = left + right;
        }

        return max[0];
    }

    // max of left tree + max of right tree + 1
    public int maxDepth(TreeNode root, int[] max) {
        if(root == null) return 0;

        int left  = maxDepth(root.left, max);
        int right = maxDepth(root.right, max);
        if((left+right) > max[0]) {
            max[0] = left + right;
        } 

        return 1 + Math.max(left, right);
    }
}