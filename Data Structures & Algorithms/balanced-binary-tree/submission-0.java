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
        boolean[] ans = new boolean[1];
        ans[0] = true;
        dfs(root,ans);
        return ans[0];
    }
    private int dfs(TreeNode root, boolean[] ans) {
        if(root == null) return 0;
        int left = dfs(root.left, ans);
        int right = dfs(root.right, ans);
        if(Math.abs(left - right) <= 1) {
            ans[0] = ans[0] && true;
        } else {
            ans[0] = ans[0] && false;
        }
        return 1 + Math.max(left, right);
    }
}
