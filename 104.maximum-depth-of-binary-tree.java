/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
 */

// @lc code=start

//  Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        // dfs input root and maxLength
        int[] maxLength = new int[] { 0 };
        dfs(root, maxLength, 0);
        return maxLength[0];
    }

    public void dfs(TreeNode root, int[] maxLength, int maxSubLength) {
        if (root == null) {
            maxLength[0] = Math.max(maxSubLength, maxLength[0]);
            return;
        }
        dfs(root.left, maxLength, maxSubLength + 1);
        dfs(root.right, maxLength, maxSubLength + 1);

    }

}

    // @lc code=end
public static void main(String[] args) {
    Solution solution = new Solution();
    TreeNode root = new TreeNode(3);
    int[] list =new int[]{3,9,20,null,null,15,7}
    
    
    
}
public TreeNode createTreeNode(TreeNode root, int[] list)
{
    root = new TreeNode(list[0]);
    
}
