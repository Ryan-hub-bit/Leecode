/*
 * @lc app=leetcode id=337 lang=java
 *
 * [337] House Robber III
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class ReturnType {
    int isRob;
    int isNotRob;

    public ReturnType(int isRob, int isNotRob) {
        this.isRob = isRob;
        this.isNotRob = isNotRob;
    }
}

class Solution {
    public int rob(TreeNode root) {
        ReturnType rt = robByLevel(root);
        return Math.max(rt.isRob, rt.isNotRob);
    }

    public ReturnType robByLevel(TreeNode root) {
        if (root == null) {
            return new ReturnType(0, 0);
        }
        ReturnType left = robByLevel(root.left);
        ReturnType right = robByLevel(root.right);
        int isRob = root.val + left.isNotRob + right.isNotRob;
        int isNotRob = Math.max(left.isRob, left.isNotRob) + Math.max(right.isRob, right.isNotRob);
        return new ReturnType(isRob, isNotRob);
    }

}
// @lc code=end
