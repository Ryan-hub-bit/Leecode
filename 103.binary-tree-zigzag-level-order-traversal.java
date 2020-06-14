import java.util.ArrayList;

/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // bfs
        // when level % 2 =1
        // list.reverse(), then add
        // or just use add
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            if (level == list.size()) {
                list.add(new ArrayList<Integer>());
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.get(level).add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            if (level % 2 == 1) {
                // List<Integer> reverse1 = new ArrayList<>();
                // reverse1 = reverse(list, level);
                // list.get(level).clear();
                // for (int j = 0; j < reverse1.size(); j++) {
                // list.get(level).add(reverse1.get(j));
                // }
                Collections.reverse(list.get(level));
            }
            level++;
        }
        return list;
    }

    // public List<Integer> reverse(List<List<Integer>> list, int level) {
    // List<Integer> ans = new ArrayList<>();
    // for (int i = list.get(level).size() - 1; i > -1; i--) {
    // ans.add(list.get(level).get(i));
    // }
    // return ans;
    // }
}
// @lc code=end
