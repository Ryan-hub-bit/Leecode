/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    TreeNode pre = null;

    // for left root and right, the order is that, and for the root part, we should
    // think root here is the root,
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left1 = isValidBST(root.left);// left
        //pre != null find the first root.left valuable TreeNode.
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;
        // root
        boolean right1 = isValidBST(root.right);
        // right
        return left1 && right1;
    }
}
// @lc code=end
