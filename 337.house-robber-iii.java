import javax.naming.spi.DirStateFactory.Result;

/*
 * @lc app=leetcode id=337 lang=java
 *
 * [337] House Robber III
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
class ResultType{
    int _rob, not_rob;
    ResultType(int _rob, int not_rob)
    {
        this._rob = _rob;
        this.not_rob = not_rob;
    }
}
class Solution {
    public int rob(TreeNode root) {
          ResultType res = helper(root);
          return Math.max(res._rob, res.not_rob);                                                                                                                 
    }
    public ResultType helper(TreeNode root)
    {
        if(root == null)
        {
            return new ResultType(0,0);
        }

        ResultType  left = helper(root.left);
        ResultType right = helper(root.right);

        int _rob = left.not_rob + right.not_rob + root.val;
        int not_rob = Math.max(left._rob,left.not_rob) + Math.max(right._rob,right.not_rob);

        return new ResultType(_rob, not_rob);

    }
}
// @lc code=end

