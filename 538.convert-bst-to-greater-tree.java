/*
 * @lc app=leetcode id=538 lang=java
 *
 * [538] Convert BST to Greater Tree
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
    public TreeNode convertBST(TreeNode root) {
       // right root right
       //sum += roo.val
       //root.val = sum;
    //    int sum =0;   
        int[] sum ={0};
       helper(root,sum);
       return root;
    }
    public void helper(TreeNode root, int[] sum)
    {
        if(root == null)
        {
            return;
        }
        helper(root.right,sum);

        sum[0] += root.val;
        root.val = sum[0];

        helper(root.left,sum);
        
    }
}
// @lc code=end

