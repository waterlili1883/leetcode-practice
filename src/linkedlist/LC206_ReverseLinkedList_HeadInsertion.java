package linkedlist;

/**
 * LC206 - Reverse Linked List (Head Insertion Method)
 *
 * Approach:
 * - Use a dummy node (newHead) to represent the new reversed list.
 * - Traverse the original list:
 *   1. Take the current node from the original list.
 *   2. Insert it right after newHead (always at the head of the new list).
 *   3. Move forward in the original list.
 * - Finally, return newHead.next as the head of the reversed list.
 *
 * Time Complexity: O(n), where n = number of nodes in the list
 * Space Complexity: O(1), in-place reversal
 */
public class LC206_ReverseLinkedList_HeadInsertion {
    public ListNode reverseList(ListNode head) {
        // Dummy node acts as the new head of the reversed list
        ListNode newHead = new ListNode(0);

        while (head != null) {
            ListNode next = head.next;      // save next node
            head.next = newHead.next;       // insert head at the front of new list
            newHead.next = head;            // update newHead to point to new head
            head = next;                    // move forward in original list
        }

        return newHead.next; // the actual head of the reversed list
    }
}
