package com.ect.leetCode.linkedList;

/**
 * Odd Even Linked List
 *
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note
 * here we are talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes)
 * time complexity.
 *
 * Given 1->2->3->4->5->NULL,
 *
 * return 1->3->5->2->4->NULL.
 *
 * 思路：定义两个节点头指向奇数和偶数
 */
public class Title324 {

    public static ListNode oddEvenList(ListNode head) {

        ListNode oddHead = new ListNode(0);

        ListNode oddNode = oddHead;

        ListNode evenHead = new ListNode(0);

        ListNode evenNode = evenHead;

        boolean oddFlag = true;
        while (head != null) {
            if (oddFlag) {
                oddNode.next = head;
                oddNode = head;
                head = head.next;
            } else {
                evenNode.next = head;
                evenNode = head;
                head = head.next;
            }
            oddFlag = !oddFlag;
        }

        evenNode.next = null;

        oddNode.next = evenHead.next;
        return oddHead.next;
    }

    // 偶数节点在奇数节点前面
    public ListNode oddEvenList2(ListNode head) {
        if (head != null) {

            ListNode odd = head, even = head.next, evenHead = even;

            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        one.next = two;
        two.next = three;
        ListNode listNode = oddEvenList(one);
        System.out.println("1111111111111");
    }
}

