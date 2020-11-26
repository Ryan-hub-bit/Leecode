/*
 * @lc app=leetcode id=328 lang=java
 *
 * [328] Odd Even Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddNode = head;
        ListNode oddHead = head;
        while (oddNode != null && oddNode.next != null) {
            oddNode.next = oddNode.next.next;
            oddNode = oddNode.next;
        }
        ListNode evenNode = head.next;
        ListNode evenHead = head.next;
        while (evenNode != null && evenNode.next != null) {
            evenNode.next = evenNode.next.next;
            evenNode = evenNode.next;
        }
        oddNode.next = evenHead;
        return oddHead;
    }
}
// @lc code=end
