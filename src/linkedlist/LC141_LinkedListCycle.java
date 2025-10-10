package linkedlist;

/**
 * LC141 - Linked List Cycle
 *
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again
 * by continuously following the next pointer.
 *
 * Approach (Floyd’s Cycle Detection Algorithm):
 *  - Use two pointers: "slow" moves one step at a time, "fast" moves two steps at a time.
 *  - If there is a cycle, the two pointers will eventually meet inside the cycle.
 *  - If fast or fast.next becomes null, the list has no cycle.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class LC141_LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        // Initialize two pointers
        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If the two pointers meet, there is a cycle
            if (slow == fast) {
                return true;
            }
        }

        // If fast reaches the end, no cycle exists
        return false;
    }
}
