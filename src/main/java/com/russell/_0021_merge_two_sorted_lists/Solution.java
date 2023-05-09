package com.russell._0021_merge_two_sorted_lists;

import com.russell.common.ListNode;

/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
 */

class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // create a dummy head for a new linked list of merged nodes, and a builder to bounce between list nodes
        // and add them to the dummy list. Uses the list pointers as runners too
        ListNode head, builder;
        head = new ListNode();
        builder = head;

        while (true) {
            // if list1 is now empty, append the rest of list2 and quit
            if (list1 == null) {
                builder.next = list2;
                break;
            }
            // if list2 is now empty, append the rest of list1 and quit
            if (list2 == null) {
                builder.next = list1;
                break;
            }
            // otherwise, if list1 is less, the runner adds the next node from list1 to the dummy list and iterates
            // list1 forward
            if (list1.val <= list2.val) {
                builder.next = list1;
                list1 = list1.next;
            } else {
                // or does that for list2, if it's the lesser value
                builder.next = list2;
                list2 = list2.next;
            }
            // move the runner forward to keep building the dummy list
            builder = builder.next;
        }

        return head.next;
    }

}



