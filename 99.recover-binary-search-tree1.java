/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
//树的中序遍历是一个有序的数组,我们只需要通过中序遍历找出一对不合法的就可以了,然后交换两个节点上的元素的val,不需要交换两个节点
class Solution {
    TreeNode pre = null;
    TreeNode firstNode = null;
    TreeNode secondNode = null;

    public void recoverTree(TreeNode root) {
        // inOrder of a tree is sorted
        // findPair for inOrder sequence which pre>post, then record it, swap them.
        if (root == null) {
            return;
        }
        findPair(root);
        // inorder find two illegal pair
        if (firstNode != null && secondNode != null) {
            swap(firstNode, secondNode);

        }
    }

    public void findPair(TreeNode root) {
        if (root == null) {
            return;
        }
        findPair(root.left);
        if (pre != null && pre.val > root.val) {
            if (firstNode == null) {
                firstNode = pre;
            }
            secondNode = root;
        }
        pre = root;
        findPair(root.right);

    }

    public void swap(TreeNode firstNode, TreeNode secondNode) {
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }
}
// @lc code=end
