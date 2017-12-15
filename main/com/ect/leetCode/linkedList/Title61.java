package com.ect.leetCode.linkedList;

/**
 * Rotate List
 *
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example:
 *
 * Given 1->2->3->4->5->NULL and k = 2,
 *
 * return 4->5->1->2->3->NULL.
 *
 * 思路： Since n may be a large number compared to the length of list. So we need to know the length
 * of linked list.After that, move the list after the (l-n%l )th node to the front to finish the
 * rotation.
 *
 * Ex: {1,2,3} k=2 Move the list after the 1st node to the front
 *
 * Ex: {1,2,3} k=5, In this case Move the list after (3-5%3=1)st node to the front.
 *
 * Created by Mr Wang :) on 17-12-15.
 */
public class Title61 {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) return head;

        // 求长度l
        int length = 1;

        ListNode zero = new ListNode(0);
        zero.next = head;

        ListNode end = head;

        while(end.next!=null){
            end = end.next;
            length++;
        }

        int index = length - (k%length);

        int i=1;
        ListNode start = head;
        while(i<index){
            start = start.next;
            i++;
        }

        end.next = head;
        zero.next = start.next;
        start.next = null;

        return zero.next;



    }

}
