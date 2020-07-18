import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
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
    public List<Integer> preorderTraversal(TreeNode root) {
       //stack 
       List<Integer> ans = new ArrayList<>();
       if(root == null)
       {
           return ans;
       }
       Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        while(!stk.isEmpty())
        {
            TreeNode curNode  = stk.pop();
            ans.add(curNode.val);
            if(curNode.right != null)
            {
                stk.push(curNode.right);
            }

            if(curNode.left != null)
            {
                stk.push(curNode.left);
            }
        }
        return ans;
    }
}
// @lc code=end

