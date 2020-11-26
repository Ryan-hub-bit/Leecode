/*
 * @lc app=leetcode id=653 lang=java
 *
 * [653] Two Sum IV - Input is a BST
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        InOrder(root, list);
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int curVal = list.get(l) + list.get(r);
            if (curVal == k) {
                return true;
            } else if (curVal < k) {
                l++;
            } else {
                r--;
            }
        }
        return false;
    }

    public void InOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        InOrder(root.left, list);
        list.add(root.val);
        InOrder(root.right, list);
    }
}
// @lc code=end
