/*
 * @lc app=leetcode id=116 lang=java
 *
 * [116] Populating Next Right Pointers in Each Node
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
       //bfs
     
       Queue<Node> queue = new LinkedList<>();
       queue.add(root);
       while(!queue.isEmpty())
       {    
        //    newRoot.next = null;
        //    newRoot = newRoot.next;
           int size = queue.size();
           Node prev = null;

           for(int i = 0; i < size; i++)
           {
               Node curr = queue.poll();
               if(curr != null)
               {
                   curr.next = prev;
                   queue.offer(curr.right);
                   queue.offer(curr.left);
                   prev =curr;
               }
           }
        //    for(int i = 0; i < size; i++)
        //    {
        //        Node cur = queue.poll();
        //        if (i < size - 1) {
        //            cur.next = queue.peek();
        //        }
        //        if(cur.left != null)
        //        {
        //             queue.add(cur.left);
        //        }
        //        if(cur.right !=null)
        //        {
        //            queue.add(cur.right);
        //        }
        //    }
       }

       return root;
    }
}
// @lc code=end

