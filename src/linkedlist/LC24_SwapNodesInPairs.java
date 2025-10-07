package linkedlist;

/**
 * LC24 - Swap Nodes in Pairs
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must not modify the node values — only the node connections.
 *
 * Example:
 * Input:  1 -> 2 -> 3 -> 4
 * Output: 2 -> 1 -> 4 -> 3
 *
 * Approach (Recursive):
 *  - Base case: if the list has 0 or 1 node, return as is.
 *  - Otherwise:
 *      1. Let "next" be the second node.
 *      2. Recursively swap from the third node onward.
 *      3. Reverse the current pair: next -> head.
 *  - Return the new head "next".
 *
 * Time Complexity: O(n), since each node is visited once.
 * Space Complexity: O(n), due to recursion call stack.
 */
public class LC24_SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        // Base case: 0 or 1 node, nothing to swap
        if (head == null || head.next == null) return head;

        // next points to the second node
        ListNode next = head.next;

        // Recursively swap the rest of the list starting from the third node
        ListNode newNode = swapPairs(next.next);

        // Reverse the current pair
        next.next = head;
        head.next = newNode;

        // Return new head after swapping
        return next;
    }
}
