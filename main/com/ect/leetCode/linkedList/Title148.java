package com.ect.leetCode.linkedList;

/**
 * sort List Sort a linked list in O(n log n) time using constant space complexity.
 *
 * 思路：将链表分割成两列，然后进行merging
 */
public class Title148 {

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // 定义两个节点一快一慢，来对链表记性分割
        ListNode slow = head;
        ListNode quick = head;
        ListNode pre = null;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            pre = slow;
            slow = slow.next;
        }


        pre.next = null;


        // 左边排序
        ListNode h1 = sortList(head);

        // 右边排序
        ListNode h2 = sortList(slow);

        return merging(h1, h2);

    }

    public static ListNode merging(ListNode head1, ListNode head2) {

        ListNode node = new ListNode(1);
        ListNode head = node;
        while (head1 != null && head2 != null) {
            if (head1.val > head2.val) {
                node.next = head2;
                head2 = head2.next;
            } else {
                node.next = head1;
                head1 = head1.next;
            }
            node = node.next;
        }

        if (head1 != null) {
            node.next = head1;
        }

        if (head2 != null) {
            node.next = head2;
        }

        return head.next;
    }
}
