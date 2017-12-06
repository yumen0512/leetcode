package com.ect.leetCode.tree;

import java.util.Stack;

/**
 * Second Minimum Node In a Binary Tree
 *
 *  找到第二小的节点
 *
 * Created by wangjunyu on 17-11-27.
 */
public class Title671 {

    public int findSecondMinimumValue(TreeNode root) {

        if (root == null) return -1;

        Stack<Integer> stack = new Stack<>();

        findSecondMin(root, stack, root.val);

        return stack.isEmpty() ? -1 : stack.peek();

    }

    private void findSecondMin(TreeNode treeNode, Stack<Integer> stack, int min) {

        if (treeNode == null) return;

        if (treeNode.val > min && (stack.isEmpty() || treeNode.val < stack.peek())) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
            stack.push(treeNode.val);
        }

        findSecondMin(treeNode.left, stack, min);
        findSecondMin(treeNode.right, stack, min);
    }

}
