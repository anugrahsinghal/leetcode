/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if(p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } 
        else {
            return root;
        }
        // can also be written as
        // else if (p.val == root.val || q.val == root.val) {
        //     return root; 
        //     // if one of the val(p or q) is found 
        //     // it will be the LCA as we have eliminated them being smaller/bigger already above
        // } else {
        //     // this means 
        //     // one val lies on left of root
        //     // other on right of root
        //     // so current node will be the LCA
        //     // this is also because we already elimiated paths before
        //     return root;
        // }
    }
}