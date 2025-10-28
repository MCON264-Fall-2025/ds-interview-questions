package edu.touro.mcon264.l13_reorder_list;

import static org.junit.jupiter.api.Assertions.*;
import static edu.touro.mcon264.l13_reorder_list.Solution.ListNode;
import static edu.touro.mcon264.l13_reorder_list.Solution.reorderList;



import org.junit.jupiter.api.Test;

class SolutionTest {
    // TODO: Add tests for Reorder List (L0→Ln→L1→Ln-1…)
    // Helper method to build a linked list from given values
    private Solution.ListNode list(int... a) {
        Solution.ListNode dummy = new Solution.ListNode(0);
        ListNode cur = dummy;
        for (int x : a) {
            cur.next = new ListNode(x);
            cur = cur.next;
        }
        return dummy.next;
    }

    // Helper method to convert linked list to int array for easy comparison
    private int[] toArray(ListNode head) {
        java.util.ArrayList<Integer> out = new java.util.ArrayList<>();
        while (head != null) {
            out.add(head.val);
            head = head.next;
        }
        return out.stream().mapToInt(i -> i).toArray();
    }

    @Test
    void oddLength_works() {
        // Input: 1 → 2 → 3 → 4 → 5
        ListNode head = list(1, 2, 3, 4, 5);
        reorderList(head);

        // Expected output: 1 → 5 → 2 → 4 → 3
        assertArrayEquals(new int[]{1, 5, 2, 4, 3}, toArray(head));
    }

    @Test
    void evenLength_works() {
        // Input: 10 → 20 → 30 → 40
        ListNode head = list(10, 20, 30, 40);
        reorderList(head);

        // Expected output: 10 → 40 → 20 → 30
        assertArrayEquals(new int[]{10, 40, 20, 30}, toArray(head));
    }

    @Test
    void smallLists_noChangeOrSimpleMerge() {
        // Empty list
        ListNode h1 = list();
        reorderList(h1);
        assertArrayEquals(new int[]{}, toArray(h1));

        // Single node
        ListNode h2 = list(7);
        reorderList(h2);
        assertArrayEquals(new int[]{7}, toArray(h2));

        // Two nodes
        ListNode h3 = list(1, 2);
        reorderList(h3);
        assertArrayEquals(new int[]{1, 2}, toArray(h3));
    }
}
