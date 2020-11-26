/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        // fast slow pointer to get the second half part
        if (head == null || head.next == null)
            return true;
        // LinkedList fast should start with the head.next,
        // slow should be head
        // we also need to judge if the fast == null && fast.next == null
        // because we let fast equals to the next and next of the fast
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        ListNode newHead = cut(head, slow);
        return isEqual(newHead, reverse(slow));
    }

    public ListNode cut(ListNode head, ListNode slow) {
        ListNode newHead = head;
        while (head.next != slow) {
            head = head.next;
        }
        head.next = null;
        return newHead;
    }

    public ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public boolean isEqual(ListNode l1, ListNode l2) {

        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        return true;
    }
}
// @lc code=end
