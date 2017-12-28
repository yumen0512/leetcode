package com.ect.leetCode.linkedList;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 删除链表中的重复部分
 * Remove Duplicates from Sorted List II
 *
 * Given a sorted linked list, delete all nodes that have
 * duplicate numbers, leaving only distinct numbers from the original list.
 *
 * For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given 1->1->1->2->3, return 2->3. Created
 * by Mr Wang :) on 17-12-22.
 */
public class Title82 {

    public ListNode deleteDuplicates(ListNode head) {

        Map<Integer, Integer> nums = new HashMap<>();

        ListNode node = head;

        while (node != null) {
            if (nums.containsKey(node.val)) {
                int val = nums.get(node.val) + 1;
                nums.put(node.val, val);
            } else {
                nums.put(node.val, 1);
            }
            node = node.next;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        node = head;

        while (node != null) {
            if (nums.get(node.val) == 1) {
                queue.add(node.val);
            }
            node = node.next;
        }

        node = head;

        ListNode pre = new ListNode(-1);
        ListNode newHead = pre;


        while (!queue.isEmpty()) {
            node.val = queue.poll();
            pre.next = node;
            pre = node;
            node = node.next;
        }

        if (node != null) {
            pre.next = null;
        }

        return newHead.next;


    }

    public ListNode deleteDuplicates2(ListNode head) {

        ListNode preHead = new ListNode(-1);

        ListNode pre = preHead;

        preHead.next = head;

        ListNode node = head;

        while (node != null) {

            while (node.next != null && node.val == node.next.val) {
                node = node.next;
            }

            if (pre.next == node) {
                pre = pre.next;
            } else {
                pre.next = node.next;
            }

            node = node.next;
        }

        return preHead.next;
    }

    /**
     * 递归方式
     */
    public ListNode deleteDuplicates3(ListNode head) {

        if (head == null) return null;

        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;

    }


}
