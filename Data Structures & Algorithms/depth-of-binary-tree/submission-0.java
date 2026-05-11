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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return maxDepth(root, 0);
    }
    private int maxDepth(TreeNode root, int depth) {
        if(root == null) return 0;
        depth = depth + 1;
        int leftDepth = maxDepth(root.left, depth);
        int rightDepth = maxDepth(root.right, depth);
        return Math.max(Math.max(leftDepth, rightDepth),depth);
    }
}
