package linkedlist;

/**
 * LC203 - Remove Linked List Elements (Dummy Head approach)
 *
 * Approach:
 * - Use a dummy head node to simplify edge cases (e.g., removing the first node).
 * - Traverse the list with a pointer (cur).
 * - If cur.next.val == target, skip cur.next.
 * - Otherwise, move cur forward.
 * - Finally, return dummy.next as the new head.
 *
 * Time Complexity: O(n), where n = number of nodes
 * Space Complexity: O(1), in-place modification
 */
public class LC203_RemoveLinkedListElements_Dummy {

    public ListNode removeElements(ListNode head, int val) {
        // Create a dummy node pointing to head
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;

        // Traverse the list
        while (cur.next != null) {
            if (cur.next.val == val) {
                // Skip the target node
                cur.next = cur.next.next;
            } else {
                // Move forward
                cur = cur.next;
            }
        }

        // Return the new head (skip dummy)
        return dummy.next;
    }
}
