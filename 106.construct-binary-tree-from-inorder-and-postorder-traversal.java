/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
      
     TreeNode root = dfs(inorder,0,inorder.length-1,postorder,0,postorder.length-1);

     return root;

    }
    public TreeNode dfs(int[] inorder, int inStart, int inEnd,int[] postorder, int pStart, int pEnd)
    {
        if(inStart > inEnd || pStart > pEnd)
        {
            return null;
        }

        TreeNode  root = new TreeNode(postorder[pEnd]);

        for(int i = inStart; i <= inEnd; i++)
        {
            if(inorder[i] == postorder[pEnd])
            {
                root.left = dfs(inorder,inStart,i-1,postorder,pStart,pStart +i - inStart-1);
                root.right = dfs(inorder,i+1,inEnd,postorder,pStart+i-inStart, pEnd-1);
            }
        }
        return root;

        

    }
}
// @lc code=end

