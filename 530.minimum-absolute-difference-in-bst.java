/*
 * @lc app=leetcode id=530 lang=java
 *
 * [530] Minimum Absolute Difference in BST
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    int ans = Integer.MAX_VALUE;
    TreeNode pre = null;

    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        InOrder(root);

        // while (r < list.size()) {
        // int diff = list.get(r) - list.get(l);
        // ans = Math.min(ans, diff);
        // l++;
        // r++;
        // }
        // return ans;
        return ans;
    }

    public void InOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        InOrder(root.left);
        if (pre != null) {
            ans = Math.min(ans, root.val - pre.val);
        }
        pre = root;
        // list.add(root.val);
        InOrder(root.right);
    }
}
// @lc code=end
