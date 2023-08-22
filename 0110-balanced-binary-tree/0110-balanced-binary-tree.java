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
    public boolean isBalanced(TreeNode root) {
        boolean[] balanced = new boolean[1];
        balanced[0] = true; // assume true until prove false

        height(root, balanced);

        return balanced[0];
    }

    int height(TreeNode node, boolean[] balanced) {
        if(node == null) return 0;

        var left_height = height(node.left, balanced); 
        var right_height = height(node.right, balanced);

        // if at any node the height is un-balanced
        if(Math.abs(left_height - right_height) > 1) {
            balanced[0] = false;
            return 0;// 0 because we no longer care about the rest of tree
        }

        return 1 + Math.max(left_height, right_height);
    }
}