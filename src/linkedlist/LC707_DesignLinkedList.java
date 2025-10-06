package linkedlist;
/**
 * LC707 - Design Linked List
 *
 * Implement a singly linked list that supports:
 *  - get(index): return the value of the index-th node (0-based), or -1 if invalid
 *  - addAtHead(val): insert a node at the head
 *  - addAtTail(val): append a node at the tail
 *  - addAtIndex(index, val): insert before the index-th node; if index == size, append
 *  - deleteAtIndex(index): delete the index-th node if valid
 *
 * Approach:
 *  - Maintain head and tail pointers plus an integer size.
 *  - Head/Tail inserts are O(1). Operations that require traversal are O(n).
 *
 * Time Complexity (per operation):
 *  - get: O(n)
 *  - addAtHead / addAtTail: O(1)
 *  - addAtIndex / deleteAtIndex: O(n)
 * Space Complexity: O(n) for the stored nodes; O(1) extra aux space.
 */
public class LC707_DesignLinkedList {

    /** Singly-linked node */
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    private ListNode head, tail;
    private int size;

    public LC707_DesignLinkedList() {}

    /** Return the value of the index-th node; -1 if index is invalid. */
    public int get(int index) {
        if (index < 0 || index >= size) return -1;     // bounds check
        ListNode p = head;
        for (int i = 0; i < index; i++) p = p.next;    // move to index
        return p.val;
    }

    /** Insert a node at the head. */
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = head;                              // new -> old head
        head = node;                                   // update head
        if (size == 0) tail = head;                    // single-node list
        size++;
    }

    /** Append a node at the tail. */
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        if (size == 0) {                               // empty list case
            head = node;
        } else {
            tail.next = node;                          // old tail -> new
        }
        tail = node;                                   // update tail
        size++;
    }

    /**
     * Insert a node with value val before the index-th node.
     * If index == size, append at the end.
     * If index < 0 or index > size, do nothing.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;         // invalid position
        if (index == 0) { addAtHead(val); return; }    // insert at head
        if (index == size) { addAtTail(val); return; } // insert at tail

        // Find (index-1)-th node (prev)
        ListNode prev = head;
        for (int i = 0; i < index - 1; i++) prev = prev.next;

        // Insert between prev and prev.next
        ListNode node = new ListNode(val);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    /** Delete the index-th node if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;        // out of bounds

        if (index == 0) {                              // delete head
            head = head.next;
            if (size == 1) tail = null;                // list becomes empty
        } else {
            // Find (index-1)-th node (prev)
            ListNode prev = head;
            for (int i = 0; i < index - 1; i++) prev = prev.next;

            // Bypass the index-th node
            prev.next = prev.next.next;

            // If the last node was removed, move tail
            if (index == size - 1) tail = prev;
        }
        size--;
    }
}
