/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
     TreeNode root = dfs(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
     return root;  
    }

    public TreeNode dfs( int[] preorder, int pStart, int pEnd, int[] inorder, int inStart,int inEnd)
    {
        //exit pStart = pEnd || inStart = inEnd 拆分成最小的单元了
        // if(pStart == pEnd || inStart == inEnd)
        // {
        //     return new TreeNode(pStart);
        // }
        if (pStart > pEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pStart]);
        for(int i = inStart; i <=inEnd; i++)
        {
            if(inorder[i] == preorder[pStart])
            {
                root.left = dfs(preorder,pStart+1,pStart+i-inStart,inorder,inStart,i-1);
                root.right = dfs(preorder,pStart+i-inStart+1,pEnd,inorder,i+1,inEnd);
            }
        }
        return root;
    }
}
// @lc code=end

