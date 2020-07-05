/*
 * @lc app=leetcode id=100 lang=java
 *
 * [100] Same Tree
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
    //helper input p,q, output true or false
    // divide left right dfs
    // exit if p == null && q == null return true;
    // if p == null || q == null return false;
        boolean isSameSubtree = helper(p,q);
        return isSameSubtree;

    }
    public boolean helper(TreeNode p, TreeNode q)
    {
        if(p == null && q == null)
        {
            return true;
        }

        if(p == null || q == null)
        {
            return false;
        }
        boolean left = helper(p.left, q.left);
        boolean right = helper(p.right,q.right);
        boolean rootEquals = p.val == q.val;


        return left && right && rootEquals;
    }
}
// @lc code=end

