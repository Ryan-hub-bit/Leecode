/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
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
  
    public int sumNumbers(TreeNode root) {
        int[] ans = {0};
        helper(root,0,ans);
        return ans[0];
    }
    public void helper(TreeNode root, int pathSum, int[] ans)
    {
        // if(root == null)
        // {
        //     ans[0] += pathSum;
        //     System.out.println(pathSum);
        //     pathSum = 0;
        //     return;
        // }

        // if(root!=null)
        // {
        //    pathSum = pathSum * 10 + root.val;
        //    if(root.left  == null && root.right == null)
        //    {
        //        ans[0] += pathSum;
        //    } 
        //    helper(root.left,pathSum,ans);
        //    helper(root.right,pathSum,ans);
           
        // }
        //exit 
        if(root == null) return;
        //preorder
        pathSum = pathSum * 10 + root.val;
        //if it is child node, then add the pathSum to ans 
        if(root.left == null && root.right == null)
        {
            ans[0] += pathSum;
        }
        helper(root.left, pathSum, ans);
        helper(root.right, pathSum, ans);

       

    }
}
// @lc code=end

