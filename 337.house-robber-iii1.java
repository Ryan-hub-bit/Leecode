/*
 * @lc app=leetcode id=337 lang=java
 *
 * [337] House Robber III
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
    public int rob(TreeNode root) {
     //case 1 use a flag
     //case 2

     int case1 = rob(root,false);
     int case2 = rob(root,true);
     return Math.max(case1, case2);
    }
    public int rob(TreeNode root, boolean flag)
    {
        if(root == null)
        {
            return 0;
        }
        int ans  = 0,left,right;
        if(!flag)
        {
         left = Math.max(rob(root.left,true),rob(root.left,false));
         right = Math.max(rob(root.right,true),rob(root.right,false));
         ans = left + right;
        }
        if(flag)
        {
            left = rob(root.left,false);
            right = rob(root.right,false);
            ans = left + right + root.val;
        }

        return ans;
        
    }
}
// @lc code=end

