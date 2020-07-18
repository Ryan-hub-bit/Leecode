import java.util.ArrayList;

/*
 * @lc app=leetcode id=173 lang=java
 *
 * [173] Binary Search Tree Iterator
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
class BSTIterator {
    List<Integer> list;
    int count;
    
    public void inOrder(TreeNode root)
    {
            if(root == null)
            {
                return;
            }
            this.inOrder(root.left);
            this.list.add(root.val);
            this.inOrder(root.right);
    }
    public BSTIterator(TreeNode root) {
        this.list = new ArrayList<>();
        count = 0;
        this.inOrder(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        return this.list.get(count++);

    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return this.count < this.list.size();

    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

