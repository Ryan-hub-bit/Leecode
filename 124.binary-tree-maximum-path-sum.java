/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
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
class ResultType{
    int singleC, path;
    ResultType(int singleC, int path)
    {
        this.singleC = singleC; 
        this.path = path;
    }
}
class Solution {
    public int maxPathSum(TreeNode root) {
        ResultType res = helper(root);
        return res.path;
    }
    
    public ResultType helper(TreeNode root)
    {
        if(root == null)
        {
            return new ResultType(0, Integer.MIN_VALUE);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

       int path = Math.max(left.path, right.path);
           path = Math.max(path,left.singleC + right.singleC + root.val);
       int singleC = Math.max(left.singleC,right.singleC) + root.val;
           singleC = Math.max(0,singleC);
        
        return new ResultType(singleC, path);

    }
}
// @lc code=end

