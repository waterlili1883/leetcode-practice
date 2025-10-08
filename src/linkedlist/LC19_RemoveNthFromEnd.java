package linkedlist;

/**
 * LC19 - Remove Nth Node From End of List
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Approach (Two Pointers):
 *  - Use a dummy node before head to simplify edge cases.
 *  - Move "fast" pointer n+1 steps ahead.
 *  - Move "slow" and "fast" together until "fast" reaches the end.
 *  - "slow.next" will be the node to remove.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class LC19_RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Dummy node to handle edge cases (e.g., removing the head)
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the target node
        slow.next = slow.next.next;

        // Return new head (dummy.next handles head removal)
        return dummy.next;
    }
}
