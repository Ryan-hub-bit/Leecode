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

class Solution {
    //return type branch and path

    //branch  left + root or right + root or root
    // path left + root +right  leftBranch or rightBranch
    private class ResultType {
        // singlePath: 从root往下走到任意点的最大路径，这条路径可以不包含任何点
        // maxPath: 从树中任意到任意点的最大路径，这条路径至少包含一个点
        int singlePath, maxPath; 
        ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }
    
    public int maxPathSum(TreeNode root) {
        // write your code here
        if(root == null)
        {
            return 0;
        }
        ResultType res = dfs(root);
        return res.maxPath;
    }
    
    public ResultType dfs(TreeNode root)
    {
        if(root == null)
        {
            return new ResultType(0,Integer.MIN_VALUE);
        }
        
        ResultType left = dfs(root.left);
        ResultType right = dfs(root.right);
        
        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath+right.singlePath + root.val);
        
        int singlePath = Math.max(left.singlePath,right.singlePath) + root.val;
        // System.out.println("Chian:" + Math.max(Left.chain,);
        singlePath = Math.max(singlePath,0);
        // System.out.println("Path:" + Path);
    
        return new ResultType(singlePath,maxPath);
    }
}
// @lc code=end

