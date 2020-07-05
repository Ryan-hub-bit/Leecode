/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
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
    public boolean isSymmetric(TreeNode root) {
        // input root root  output true or false
    //     return isSymmetric(root,root);
    // }
    // public boolean isSymmetric(TreeNode root1,TreeNode root2)
    // {
    //     if(root1 == null && root2 == null)
    //     {
    //         return true;
    //     }

    //     if(root1 == null || root2 == null)
    //     {
    //         return false;
    //     }

    //     return isSymmetric(root1.left,root2.right) && isSymmetric(root1.right,root2.left) && root1.val == root2.val;
    // }
    if(root == null)
    {
        return true;
    }
    List<Integer> list = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    

    while(!queue.isEmpty())
    {
        //level by level should use the size so everytime we can get 1 level.
        int size = queue.size();
        
        for(int i = 0; i < size; i++)
        {
         TreeNode cur = queue.poll();
         // 一般情况下 是在 we operate result when out of queue.
         if(cur == null)
         {
             //list可以添加null, queue 也可以添加null 
             list.add(null);
         }
         else{
             queue.offer(cur.left);
             queue.offer(cur.right);
             list.add(cur.val);
         }
        }
        
        if(!isListSymmetric(list))
        {
            return false;
        }
        list.clear();
    }
    return true;

    }
    public boolean isListSymmetric(List list)
    {
        int left = 0;
        int right = list.size() -1;
        while(left<=right)
        {
            if(list.get(left) != list.get(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
// @lc code=end

