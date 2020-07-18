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
    //stack to store right root left 
    Stack<TreeNode> stk;
    List<Integer> list;

    public BSTIterator(TreeNode root) {
        stk = new Stack<TreeNode>();
        list = new ArrayList<>();
        stk.push(root);
        
        
    }
    
    /** @return the next smallest number */
    public int next() {
        
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

