package linkedlist;

/**
 * LC203 - Remove Linked List Elements
 *
 * Given the head of a linked list and an integer val, remove all the nodes
 * of the linked list that have Node.val == val, and return the new head.
 *
 * Approach: Without using a dummy head node.
 * - First, skip all leading nodes with value == val to adjust the head.
 * - Then, traverse the list with a pointer and remove any matching nodes.
 *
 * Time Complexity: O(n), where n is the number of nodes.
 * Space Complexity: O(1).
 */
public class LC203_RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        // Skip leading nodes that should be removed
        while (head != null && head.val == val) {
            head = head.next;
        }

        // Traverse the list and remove matching nodes
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                // Remove the next node
                cur.next = cur.next.next;
            } else {
                // Move forward
                cur = cur.next;
            }
        }

        return head; // Return the new head
    }
}
