/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
 */

// @lc code=start
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
    public void flatten(TreeNode root) {
       helper(root);
    }
    public TreeNode helper(TreeNode root)
    {
        if(root == null)
        {
            return null;
        }

        TreeNode leftLastNode = helper(root.left);
        TreeNode rightLastNode = helper(root.right);

        if(leftLastNode != null)
        {
            leftLastNode.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        if(rightLastNode != null)
        {
            return rightLastNode;
        }

        if(leftLastNode != null)
        {
            return leftLastNode;
        }
        return root;
    }
}
// @lc code=end

