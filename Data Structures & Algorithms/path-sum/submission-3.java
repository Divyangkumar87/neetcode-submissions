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
    int runingSum = 0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        runingSum += root.val;
        if(root.left == null && root.right == null && runingSum == targetSum) {
            return true;
        }
        if(hasPathSum(root.left, targetSum)) {
            return true;
        }
        if(hasPathSum(root.right, targetSum)) {
            return true;
        }
        runingSum -= root.val;
        return false;
    }
}