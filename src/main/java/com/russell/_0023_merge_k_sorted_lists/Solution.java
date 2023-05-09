package com.russell._0023_merge_k_sorted_lists;

import com.russell.common.ListNode;

/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // adaptation of 21. Merge Two Sorted Lists, except that here list1 is the dummy list
        // and list2 is the next list from the array.
        ListNode head, builder, list1, list2;
        head = new ListNode();

        for (int i = 0; i < lists.length; i++) {
            // reset list1 to start of dummy list, and list2 to the next list in the array
            list1 = head.next;
            list2 = lists[i];
            builder = head;
            while (true) {
                if (list1 == null) {
                    builder.next = list2;
                    break;
                }
                if (list2 == null) {
                    builder.next = list1;
                    break;
                }
                if (list1.val <= list2.val) {
                    builder.next = list1;
                    list1 = list1.next;
                } else {
                    builder.next = list2;
                    list2 = list2.next;
                }
                builder = builder.next;
            }
        }

        return head.next;
    }
}
