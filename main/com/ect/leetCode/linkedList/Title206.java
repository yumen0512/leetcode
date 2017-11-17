package com.ect.leetCode.linkedList;

/**
 * 反转链表
 *
 * 递归调用
 * Reverse a singly linked list.
 */
public class Title206 {

    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }
        return reverseList(head, null);
    }

    private static ListNode reverseList(ListNode listNode, ListNode head) {

        ListNode next = listNode.next;

        listNode.next = head;

        if (next != null) {
            head = listNode;
            return reverseList(next, head);
        } else {
            return listNode;
        }
    }


    // 方法二 直接进行反转
    public ListNode reverseList2(ListNode head) {
    /* iterative solution */
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}