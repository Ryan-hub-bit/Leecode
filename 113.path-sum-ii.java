/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
       List<List<Integer>> res = new ArrayList<>();
       List<Integer> path = new ArrayList<>();
       dfs(root,sum,path,res);
       return res;
    }
    public void dfs(TreeNode root, int sum,List<Integer> path, List<List<Integer>> res)
    {
        if(root == null)
        {
            return;
        }
        sum -= root.val;
        path.add(root.val);
        if(root.left == null && root.right == null)
        {
            if(sum == 0)
            {
                res.add(new ArrayList<>(path));
                path.remove(path.size()-1);
                return;
            }
        }
        dfs(root.left,sum,path,res);
        dfs(root.right,sum,path,res);
        path.remove(path.size()-1);

    }
}
// @lc code=end

