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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if(helper(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    boolean helper(TreeNode node, TreeNode subRoot) {
        // if(node == null && subRoot == null) return true;
        if(node == null || subRoot == null) {
            return node == null && subRoot == null;
        }

        // if(node.val != subRoot.val) {
        //     var left = helper(node.left, subRoot);
        //     var right = helper(node.right, subRoot);
        //     return left || right;
        // } else {
        //     var left = helper(node.left, subRoot.left);
        //     var right = helper(node.right, subRoot.right);
        //     return left && right;
        // }
        return node.val == subRoot.val 
                && helper(node.left, subRoot.left) 
                && helper(node.right, subRoot.right);
    }
}