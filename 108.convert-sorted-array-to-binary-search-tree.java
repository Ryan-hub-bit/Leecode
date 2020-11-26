/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        // TreeNode root = null;
        return constructBST(nums, 0, nums.length - 1);
    }

    public TreeNode constructBST(int[] nums, int sIdx, int eIdx) {
        if (sIdx > eIdx)
            return null;
        int mid = sIdx + (eIdx - sIdx) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructBST(nums, sIdx, mid - 1);
        root.right = constructBST(nums, mid + 1, eIdx);
        return root;
    }
}
// @lc code=end
