/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
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
    public List<Integer> postorderTraversal(TreeNode root) {
        // root right left add to the list.add(0,?)
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        if (root == null)
        {
            return ans;
        }
        stk.push(root);
        TreeNode curNode;
        while(!stk.isEmpty())
        {
            curNode  = stk.pop();
            ans.add(0,curNode.val);
            if(curNode.left != null)
            {
                stk.push(curNode.left);
            }
            if(curNode.right != null)
            {
                stk.push(curNode.right);
            }
        }
        return ans;
    }
}
// @lc code=end

