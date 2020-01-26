/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
     if(l1==null)
         return l2;
     if(l2==null)
         return l1;
        ListNode head= new ListNode(0);
        ListNode dummy=head;
         int car=0;
         while(l1!=null||l2!=null)
         {
             
         int p=(l1==null)?0:l1.val;
         int q=(l2==null)?0:l2.val; 
        int sum=p+q+car;
        car=sum/10;
         head.next=new ListNode(sum%10);
         head=head.next;
         if(l1!=null) l1=l1.next;
         if(l2!=null) l2=l2.next;
        
         }
         if(car>0)
         {
             head.next=new ListNode(car);
         }
         return dummy.next;
     
    }
}
// @lc code=end

