/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
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
    public ListNode swapPairs(ListNode head) {
       if(head==null||head.next==null)
       return head;
       ListNode first=head;
       ListNode second=head.next;
       first.next=swapPairs(second.next);
       second.next=first;
       return second;

    }
}
// @lc code=end

