package linkedlist;

/**
 * LC206 - Reverse Linked List
 *
 * Reverse a singly linked list.
 *
 * Approach: Iterative Three-Pointer Method
 * - Use three pointers: prev, curr, next.
 * - At each step:
 *   1. Save the next node.
 *   2. Reverse the pointer of the current node.
 *   3. Move prev and curr forward.
 * - Continue until curr becomes null.
 * - Return prev as the new head of the reversed list.
 *
 * Time Complexity: O(n), where n = number of nodes in the list
 * Space Complexity: O(1), in-place reversal
 */
public class LC206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;    // previous node
        ListNode curr = head;    // current node

        while (curr != null) {
            ListNode next = curr.next; // 1. save next node
            curr.next = prev;          // 2. reverse the pointer
            prev = curr;               // 3. move prev forward
            curr = next;               // 4. move curr forward
        }

        return prev; // new head of the reversed list
    }
}
