/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        // pre should only be declared once, cuz we need to invoke our self everytime
        // if we declare pre here, the pre will be initialized null every time, then for every point we just get a true answer, cuz , pre is null everytime
        //then we will never go into the false function.
       if(root == null)
       {
           return true;
       }
       boolean left = isValidBST(root.left);

       if(pre != null && pre.val >= root.val)
       {
           return false;
       }
       
       pre = root;

       boolean right = isValidBST(root.right);

       return right&&left;
    }
}
// @lc code=end

