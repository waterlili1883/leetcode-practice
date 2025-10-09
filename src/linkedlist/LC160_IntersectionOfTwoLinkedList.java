package linkedlist;

/**
 * LC160 - Intersection of Two Linked Lists
 *
 * Given the heads of two singly linked lists headA and headB, return the node at which the two lists intersect.
 * If the two linked lists have no intersection, return null.
 *
 * Approach (Two Pointers):
 *  - Use two pointers p1 and p2 starting at headA and headB respectively.
 *  - Move both pointers one step at a time.
 *  - When one pointer reaches the end, redirect it to the head of the other list.
 *  - If the lists intersect, the two pointers will meet at the intersection node.
 *    Otherwise, both will reach null at the same time.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class LC160_IntersectionOfTwoLinkedList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Two pointers starting from headA and headB
        ListNode p1 = headA;
        ListNode p2 = headB;

        // Traverse both lists; switch to the other list when reaching the end
        while (p1 != p2) {
            p1 = (p1 == null) ? headB : p1.next;
            p2 = (p2 == null) ? headA : p2.next;
        }

        // Either both null (no intersection) or both at intersection node
        return p1;
    }
}

