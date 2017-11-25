package com.ect.leetCode.linkedList;

/**
 * Swap Nodes in Pairs
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * 思路：直线思维，依次交替返回
 *
 * Created by wangjunyu on 17-11-25.
 */
public class Title24 {

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode node = new ListNode(0);

        head = swapPairsFunction(node, head, head.next);

        return head.next;
    }

    private static ListNode swapPairsFunction(ListNode pre, ListNode slow, ListNode quick) {

        ListNode head = pre;

        if (quick == null) return pre;

        slow.next = quick.next;

        pre.next = quick;

        quick.next = slow;

        // 快慢交换
        ListNode temp = slow;
        slow = quick;
        quick = temp;

        // 递归调用下一次交换
        pre = quick;

        if (quick.next != null) {
            swapPairsFunction(pre, quick.next, quick.next.next);
        }

        return head;
    }

    // 递归实现，还没看
    public ListNode swapPairs2(ListNode head) {

        if ((head == null) || (head.next == null)) return head;

        ListNode n = head.next;

        head.next = swapPairs(head.next.next);

        n.next = head;

        return n;
    }


}
