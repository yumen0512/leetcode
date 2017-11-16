package com.ect.leetCode.linkedList;

/**
 * 反转链表
 * Reverse a singly linked list.
 */
public class Title206 {

    public ListNode reverseList(ListNode head) {

        if(head==null) return null;

        ListNode node = head.next;
        ListNode pre = head;

        while(node!=null){

            ListNode next = node.next;
            // 如果不是最后一个节点
            if(next!=null){
                node.next = pre;
                if(pre==head){
                    pre.next=null;
                }
                pre = node;
                node = next;
            }else{
               node.next = pre;
                if(pre==head){
                    pre.next=null;
                }
               pre = node;
               node = null;
            }

        }
        return pre;
    }
}