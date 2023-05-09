package com.russell._0141_linked_list_cycle;

import com.russell.common.ListNode;

/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is
connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.
 */

public class Solution {
    public boolean hasCycle(ListNode head) {
        // t=O(n), s=O(1)
        // if you have a fast pointer and a slow pointer traverse the list, eventually they will meet if
        // a cycle exists. If there's no cycle, fast will hit the end of the list first
        int counter = 0;
        ListNode fast = head;
        ListNode slow = head;
        if (head == null)
            return false;
        while (true) {
            slow = slow.next;
            if (fast.next == null)
                return false;
            fast = fast.next;
            if (fast.next == null)
                return false;
            fast = fast.next;
            if (fast == slow) {
                return true;
            }
        }

        /*
        // t=O(n), s=O(n)
        // just add each node to a set, and if the add fails you have a cycle
        Set<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (!visited.add(head))
                return true;
            head = head.next;
        }
        return false;
        */
    }
}
