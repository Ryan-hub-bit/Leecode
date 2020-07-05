/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
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
    TreeNode firstNode = null;
    TreeNode secondNode = null;
    TreeNode preNode = null;
    public void recoverTree(TreeNode root) {
            if(root == null)
            {
                return;
            }
            
            findPair(root);
            if(firstNode != null && secondNode != null)
            {
                swap(firstNode, secondNode);
            }

    }

    public void findPair(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        findPair(root.left);
        if (preNode != null && preNode.val > root.val) {
            // 1 2 5 4 3
            //     f s
            //     f   s
            // 最大的和最小的交换位置就可以了, 因为只有两个点出现了位置对调,所以第一次出现前一个节点大于后一个节点的时候,这个前一个节点一定是出错的节点,但是后面这个节点可能还不是出错的那一个
            // 因为后边的节点可能还大于 后边的后边的节点,所以我们直接把 前一个节点和后边的节点交换位置就可以,findpair
            
            if (firstNode == null) {
                firstNode = preNode;
            }
            secondNode = root;
        }
        preNode = root;
        findPair(root.right);
    }
    public void swap(TreeNode firstNode,TreeNode secondNode)
    {
        int dummy = secondNode.val;
        secondNode.val = firstNode.val;
        firstNode.val = dummy;

    }
}
// @lc code=end

