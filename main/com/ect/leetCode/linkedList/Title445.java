package com.ect.leetCode.linkedList;

import java.util.Stack;

/**
 * Add Two Numbers II
 * You are given two non-empty linked lists representing two non-negative
 * integers. The most significant digit comes first and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 8 -> 0 -> 7
 *
 * 思路： 1将链表压入栈，后压入的链表尾部先弹出。
 *       2循环：new一个当前节点同时，new一个head节点。下一次遍历赋值此刻的head节点
 *       3最后判断head节点是0还是1,1表示最后还有进位，将head返回，0表示没有进位，返回head.next
 */
public class Title445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        ListNode node = l1;

        while (node != null) {
            stack1.push(node.val);
            node = node.next;
        }

        node = l2;

        while (node != null) {
            stack2.push(node.val);
            node = node.next;
        }

        ListNode after = null;

        int carryOver = 0;

        while (!stack1.isEmpty() || !stack2.isEmpty()) {

            int sum = carryOver;

            if (!stack1.isEmpty()) {
                sum = sum + stack1.pop();
            }

            if (!stack2.isEmpty()) {
                sum = sum + stack2.pop();
            }

            if (sum >= 10) {
                carryOver = 1;
                sum -= 10;
            }
            else{
                carryOver = 0;
            }

            if (after == null) {
                ListNode listNode = new ListNode(sum);
                after = listNode;
            } else {
                ListNode listNode = new ListNode(sum);
                listNode.next = after;
                after = listNode;
            }

        }

        if(carryOver==1){
            ListNode listNode = new ListNode(1);
            listNode.next = after;
            after = listNode;
        }

        return after;
    }


    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        };
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode list = new ListNode(0);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            list.val = sum % 10;
            // 定义前一个节点
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            // 算出进位
            sum /= 10;
        }

        // 判断有没有进位
        return list.val == 0 ? list.next : list;
    }


}
