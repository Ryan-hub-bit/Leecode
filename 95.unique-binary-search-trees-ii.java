/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        // 1 2 3 4 5 6 7 8 9
        // from 1 - n every node can be root node,
        // the left of the root node will be the left , the right part of the root node
        // will be the right
        // in the left , we can also find a root node, and the left and the right, thr
        // right is the same
        // when the minimum piece is 1 which is start = end, we can create a treeNode
        // and add them to our ans;
        // if the root in the first element, which means the left of this root is null,
        // the right is the same
        List<TreeNode> ans = new LinkedList<>();
        if (n == 0) {
            return ans;
        }
        return generateTrees(1, n);

    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start == end) {
            TreeNode node = new TreeNode(start);
            res.add(node);
            return res;
        }
        List<TreeNode> left = new ArrayList<>();
        List<TreeNode> right = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            if (i - 1 >= start) {
                left = generateTrees(start, i - 1);
            } else {
                left.add(null);
            }

            if (i + 1 <= end) {
                right = generateTrees(i + 1, end);
            } else {
                right.add(null);
            }
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode finalNode = new TreeNode(i);
                    finalNode.left = l;
                    finalNode.right = r;
                    res.add(finalNode);
                }
            }
            left.clear();
            right.clear();
        }
        return res;
    }
}
// @lc code=end
