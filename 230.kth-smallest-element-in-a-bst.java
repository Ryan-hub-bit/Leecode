/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    int ans = -1;
    int cnt = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        inorder(root, k);
        return ans;
    }

    public void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inorder(root.left, k--);
        // cnt++;
        // if (cnt == k) {
        // ans = root.val;
        // return;
        // }
        // k--;
        if (k == 0) {
            ans = root.val;
            return;
        }
        inorder(root.right, k--);
    }
}
// @lc code=end
