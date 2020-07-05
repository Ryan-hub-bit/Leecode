import java.util.Queue;

import org.w3c.dom.Node;

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
        if(root == null)
        {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            Node prev = null;
            int size = queue.size();
            for(int i = 0; i < size; i ++)
            {
                Node cur  = queue.poll();
                // if(cur != null)
                // {
                if(prev != null)
                {
                    cur.next = prev;
                }
                // queue.add(cur.right);
                // queue.add(cur.left);
                if(cur.right != null)
                {
                    queue.add(cur.right);
                }

                if(cur.left != null)
                {
                    queue.add(cur.left);
                }

                
                prev = cur;
                // }
            }
        }
        return root;
    }
}
// @lc code=end

