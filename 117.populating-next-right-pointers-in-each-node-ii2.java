import org.graalvm.compiler.graph.Node;

/*
 * @lc app=leetcode id=117 lang=java
 *
 * [117] Populating Next Right Pointers in Each Node II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
       dfs(root);
       return root; 
    }
    public void dfs(Node root)
    {
        if(root == null)
        {
            return;
        }

        if(root.left != null)
        {
            if(root.right != null)
            {
            root.left.next =root.right;
            }
            else if(root.next != null){
                if(root.next.left != null)
                {
                root.left.next = root.next.left;
                }
                else{
                    root.left.next = root.next.right;
                }
            }
            else{
                root.left.next = null;
            }
        }

        if(root.right != null)
        {
            root.right.next = (root.next == null) ? null :root.next.right;
        }

        dfs(root.left);
        dfs(root.right);
    }
}
// @lc code=end

