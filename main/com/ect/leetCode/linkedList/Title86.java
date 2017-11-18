package com.ect.leetCode.linkedList;

/**
 * 分割链表
 * Partition List Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 *
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 */
public class Title86 {

    public ListNode partition(ListNode head, int x) {

        ListNode lessHead = new ListNode(0);
        ListNode moreHead = new ListNode(0);

        ListNode less = lessHead;
        ListNode more = moreHead;

        while (head!=null){
            if(head.val>=x){
                more.next = head;
                more = head;
            }
            else{
                less.next = head;
                less = head;
            }
            head = head.next;
        }

        more.next =null;
        less.next = moreHead.next;
        return lessHead.next;
//        ListNode less = null;
//        ListNode more = null;
//
//        ListNode moreHead = null;
//        ListNode lessHead = null;
//
//        ListNode listNode = head;
//        while(listNode !=null){
//            // 大于当前数字
//            if(listNode.val>=x){
//                // 如果大于x链表节点未初始化
//                if(more == null){
//                    more = listNode;
//                    moreHead = listNode;
//                }
//                else{
//                    more.next = listNode;
//                    more = listNode;
//                }
//                listNode = listNode.next;
//                // 断掉之前的链接，避免循环
//                more.next = null;
//            }
//            else{
//                if(less==null){
//                    less = listNode;
//                    lessHead = listNode;
//                }
//                else{
//                    less.next = listNode;
//                    less = listNode;
//                }
//                listNode = listNode.next;
//                // 断掉之前的链接，避免循环
//                less.next = null;
//            }
//
//        }
//
//        if(lessHead==null){
//            return moreHead;
//        }
//        else{
//            less.next = moreHead;
//            return lessHead;
//        }
    }
}
