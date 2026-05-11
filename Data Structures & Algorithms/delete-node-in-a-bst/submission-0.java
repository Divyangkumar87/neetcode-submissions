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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if(key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            //case 1 : 0 or 1 children
            //case 2 : 2 children

            if(root.right == null) return root.left;
            if(root.left == null) return root.right;

            root.val = findMin(root.right).val;
            root.right = deleteNode(root.right, root.val);
        }   
        return root;
    }
    private TreeNode findMin(TreeNode root) {
        TreeNode current = root;
        while(current != null && current.left != null) {
            current = current.left;
        }
        return current;
    } 
}