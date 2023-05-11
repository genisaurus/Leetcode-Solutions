package com.russell._0876_middle_of_the_linked_list;

import com.russell.common.ListNode;

/*
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.
 */

class Solution {
    public ListNode middleNode(ListNode head) {
        // you could do this with a fast & slow pointer where fast advances .next.next, but instead
        // here the slow pointer only advances every other iteration. So when the head has iterated off the last node,
        // the runner will be at the middle
        int stepCounter = 0;
        ListNode runner = head;
        while (head != null) {
            stepCounter++;
            if (stepCounter % 2 == 0)
                runner = runner.next;
            head = head.next;
        }

        return runner;
    }
}
