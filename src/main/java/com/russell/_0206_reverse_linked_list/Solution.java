package com.russell._0206_reverse_linked_list;

/*
Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

import com.russell.common.ListNode;

class Solution {
    public ListNode reverseList(ListNode head) {
        // classic 3-pointer solution
        ListNode p = null, n = null;

        while (head != null) {
            n = head.next;
            head.next = p;
            p = head;
            head = n;
        }
        return p;
    }
}
