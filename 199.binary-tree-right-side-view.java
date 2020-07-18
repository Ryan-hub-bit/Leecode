/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
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
    //root right left
    // list.add(root.val);
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
        {
            return ans;
        }
        helper(root,0,ans);
        return ans;
    }
    public void helper(TreeNode root, int level, List<Integer> ans)
    {
        if(root == null)
        {
            return;
        }
        if(level  == ans.size())
        {
            ans.add(root.val);
        }
        // if(root.right != null)
        // {
        helper(root.right,level+1,ans);
        // }
        // if(root.left != null)
        // {
        helper(root.left,level+1,ans);
        // }
    }
}
// @lc code=end

