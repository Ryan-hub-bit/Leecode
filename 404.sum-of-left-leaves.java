/*
 * @lc app=leetcode id=404 lang=java
 *
 * [404] Sum of Left Leaves
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    int leftSum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return leftSum;
        }
        dfs(root);
        return leftSum;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            leftSum += root.left.val;
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
        }
    }
}
// @lc code=end
