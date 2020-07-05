/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {

    // 当我们这边的返回类型的时候是void 或者int 时我们可以直接递归函数,但是当我们的返回类型是list set 或者是数据时,我们可以
    // 申明全局变量然后通过辅助函数改变全局变量,最后返回改变后的全局变量
    List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        helper(root);
        return ans;

    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        ans.add(root.val);
        helper(root.right);
    }
}
// @lc code=end
