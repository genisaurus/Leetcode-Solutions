package com.russell._0142_linked_list_cycle_II;

import com.russell.common.ListNode;

/*
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is
connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.
 */

public class Solution {
    public ListNode detectCycle(ListNode head) {
        // t=O(n), s=O(1)
        // As in 141. Linked List Cycle, if you have a fast pointer and a slow pointer traverse the list,
        // they will eventually meet if there's a cycle, and if not, fast will know first.
        // HOWEVER, once they DO meet, then the distance between the head and the cycle point will be the same as the
        // distance between the slow/fast pointers and the cycle point. So you iterate slow and head until they meet
        // and return that node.
        // Proof:
        // - distance between head and cycle point is labelled x1
        // - if a cycle exists, fast will pass the point before slow
        // - if fast is passing the cycle point before slow, it will pass the cycle point AGAIN before meeting slow
        // - distance between cycle point and meeting point is labelled x2
        // - distance between meeting point and cycle point is labelled x3.
        // - slow will traverse x1+x2
        // - fast will traverse x1+x2+x3+x2
        // - they meet, and fast is travelling 2x faster than slow : 2(x1+x2) = x1+x2+x3+x2
        // - 2(x1)+2(x2) = x1+2(x2)+x3
        // - 2(x1) = x1+x3
        // - x1 = x3
        int counter = 0;
        ListNode fast = head;
        ListNode slow = head;
        if (head == null)
            return null;
        // find the meeting point (x2)
        while (true) {
            slow = slow.next;
            if (fast.next == null)
                return null;
            fast = fast.next;
            if (fast.next == null)
                return null;
            fast = fast.next;
            if (fast == slow) {
                break;
            }
        }
        // find the cycle point (x1 || x3)
        while (true) {
            if (head == slow)
                break;
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}
