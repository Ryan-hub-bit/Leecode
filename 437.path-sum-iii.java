import java.util.Map;

/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    int count = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return count;
        }
        preorder(root, 0, sum);
        return count;
    }

    public void preorder(TreeNode root, int cur, int sum) {
        if (root == null) {
            return;
        }
        cur += root.val;
        if (cur == sum) {
            count++;
        }
        if (map.containsKey(cur - sum)) {
            count += map.get(cur - sum);
        }
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        preorder(root.left, cur, sum);
        preorder(root.right, cur, sum);
        map.put(cur, map.get(cur) - 1);
    }

}
// @lc code=end
