/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
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
    public TreeNode sortedArrayToBST(int[] nums) {
        //dfs  a half and a half 0, nums.length-1;
        // if(nums.length == 0)
        // {
        //     return null;
        // }
        // if(nums.length == 1)
        // {
        //     return new TreeNode(nums[0]);
        // }
        TreeNode root = dfs(nums,0,nums.length-1);
        return root;
    }
    public TreeNode dfs(int[] nums, int start, int end)
    {
        if(start  > end)
        {
            return null;
        }

        // int slow  = start;
        // int faster = start+1;
        // while(faster+1<end)
        // {
        //     slow++;
        //     faster += 2;
        // }
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left =  dfs(nums,start,mid-1);
        root.right = dfs(nums,mid+1,end);

        return root;


    }
}
// @lc code=end

