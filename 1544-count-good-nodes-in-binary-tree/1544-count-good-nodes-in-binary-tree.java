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
    public int goodNodes(TreeNode root) {
        int[] good = new int[]{0};
        helper(root, good, root.val);
        return good[0];
    }

    void helper(TreeNode node, int[] good, int max) {
        if(node == null) return;
        System.out.println(node.val + "--" + good[0] + "--" + max);

        if(node.val >= max) {
            good[0] += 1;
        }
        helper(node.left, good, Math.max(max, node.val));
        helper(node.right, good, Math.max(max, node.val));
    }
}