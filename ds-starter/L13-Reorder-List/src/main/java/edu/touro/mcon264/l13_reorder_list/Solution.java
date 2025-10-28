package edu.touro.mcon264.l13_reorder_list;

public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int v) {
            this.val = v;
        }

        ListNode(int v, ListNode n) {
            this.val = v;
            this.next = n;
        }
    }


    // TODO: Implement solution for: Reorder List (L0→Ln→L1→Ln-1…)
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 1) Find the middle (slow stops at the end of left half)
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2) Split and reverse right half
        ListNode head2 = slow.next;
        slow.next = null;
        head2 = reverse(head2);

        // 3) Merge alternately: head (left) with head2 (right)
        ListNode p1 = head, p2 = head2;
        while (p2 != null) {
            ListNode n1 = p1.next;
            ListNode n2 = p2.next;
            p1.next = p2; // link a right node after left
            p2.next = n1; // then back to next left node

            // advance
            p1 = n1;
            p2 = n2;
        }
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
