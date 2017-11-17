package com.ect.leetCode.linkedList;

/**
 * Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a new list. The new list should be made by
 * splicing together the nodes of the first two lists.
 *
 * 思路 1 递归合并
 * 思路 2 new 一个新的
 * Created by wangjunyu on 17-11-17.
 */
public class Title21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        if(l1.val<l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
