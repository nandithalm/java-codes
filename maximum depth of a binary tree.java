//leetcode

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *
 *     TreeNode() {}
 *
 *     TreeNode(int val) {
 *         this.val = val;
 *     }
 *
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    public boolean isBalanced(TreeNode root) {

        // Base case
        if (root == null) {
            return true;
        }

        // Find height of left and right subtrees
        int left = height(root.left);
        int right = height(root.right);

        // Check if current node is balanced
        if (Math.abs(left - right) > 1) {
            return false;
        }

        // Recursively check left and right subtrees
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root) {

        // Base case
        if (root == null) {
            return 0;
        }

        // Return height of the subtree
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
