/*
 * @lc app=leetcode id=572 lang=java
 *
 * [572] Subtree of Another Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s != null) {
            return equals(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }
        return t == null ? true : false;
    }

    public boolean equals(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }

        if (s == null || t == null) {
            return false;
        }
        return s.val == t.val && equals(s.left, t.left) && equals(s.right, t.right);
    }
}
// @lc code=end
