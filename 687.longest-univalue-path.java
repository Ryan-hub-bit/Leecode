/*
 * @lc app=leetcode id=687 lang=java
 *
 * [687] Longest Univalue Path
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        findPath(root);
        return ans;
    }

    public int findPath(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = findPath(node.left);
        int right = findPath(node.right);
        int leftPath = node.left != null && node.left.val == node.val ? left + 1 : 0;
        int rightPath = node.right != null && node.right.val == node.val ? right + 1 : 0;
        ans = Math.max(ans, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }
}
// @lc code=end
