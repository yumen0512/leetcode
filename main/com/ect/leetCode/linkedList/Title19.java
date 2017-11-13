package com.ect.leetCode.linkedList;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Created by wangjunyu on 17-11-13.
 */
public class Title19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null || head.next == null)
            return null;

        ListNode faster = head;
        ListNode slower = head;

        for(int i = 0; i<n; i++)
            faster = faster.next;

        if(faster == null){
            head = head.next;
            return head;
        }

        while(faster.next != null){
            slower = slower.next;
            faster = faster.next;
        }

        slower.next = slower.next.next;
        return head;
    }

}
