package com.ect.leetCode.linkedList;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
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
}
