package com.ect.leetCode.linkedList;

/**
 * Linked List Cycle
 * Given a linked list, determine if it has a cycle in it.
 * 检测代码中是否有循环
 * 思路：定义一个快指针，慢指针，如果有环，指针会中途相遇
 *
 */
public class Title141 {

    public boolean hasCycle(ListNode head) {

        if(head==null) return false;

        ListNode quick = head.next;
        ListNode slow = head;

        boolean hasCycle = false;

        while(quick!=null){
            if(quick==slow){
                hasCycle = true;
                break;
            }
            slow = slow.next;
            quick = quick.next==null?null:quick.next.next;
        }

        return hasCycle;
    }
}
