import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=101 lang=java *
 * [101] Symmetric Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // bfs
        // see if every level is legal
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

                for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();

                if (cur == null) {
                    list.add(null);
                } else {
                    list.add(cur.val);
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }
            if (!isSymmetric(list)) {
            return false;
            }
            list.clear();
        }
        return true;
    }

    boolean isSymmetric(List<Integer> list) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (list.get(left) != list.get(right)) {
                return false;
            }
            left++;
            right--;
        }
       return true;
     
    }
}
// @lc code=end

