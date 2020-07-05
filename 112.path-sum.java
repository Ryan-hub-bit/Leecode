/*
 * @lc app=leetcode id=112 lang=java
 *
 * [112] Path Sum
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
    public boolean hasPathSum(TreeNode root, int sum) {
            //exit 
            if(root == null)
            {
                return false;
            }

            return dfs(root,sum,0);
    }
    public boolean dfs(TreeNode root, int sum,int temp)
    {
        if(root == null )
        {
            return false;
        }
        if(root.left ==  null && root.right == null)
        {
            if(temp == sum)
            {
                return true;
            }
            return false;
        }
        temp  += root.val;

            boolean left = dfs(root.left,sum,temp );
            boolean right = dfs(root.right,sum,temp);

            return left || right;
    }
}
// @lc code=end

