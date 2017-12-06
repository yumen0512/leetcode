package com.ect.leetCode.tree;

import java.util.Stack;

/**
 * Symmetric Tree
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 *
 * Bonus points if you could solve it both recursively and iteratively.
 *
 * Created by wangjunyu on 17-12-6.
 */
public class Title101 {

    // 方法1：递归
    public boolean isSymmetric(TreeNode root) {
        return isMirrorTree(root, root);
    }

    // 思路：两树根节点相同，且左右子树镜像
    private static boolean isMirrorTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if ((left == null && right != null) || (left != null && right == null)) {
            return false;
        }

        if (left.val != right.val) return false;

        return isMirrorTree(left.left, right.right) && isMirrorTree(left.right, right.left);
    }

    // 思路2：迭代 左子树的右子树和右子树的左子树，左子树的左子树和右子树的右子树相同
    public boolean isSymmetric2(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

        if (root == null) return true;

        if (root.left == null) {
            if (root.right != null) return false;
            return true;
        }

        if (root.right == null) {
            return false;
        }

        stack.push(root.left);
        stack.push(root.right);

        while (!stack.isEmpty()) {

            TreeNode left = stack.pop();
            TreeNode right = stack.pop();

            if (left == null && right == null) {
                continue;
            }

            if ((left == null && right != null) || (left != null && right == null)) {
                return false;
            }

            if (left.val != right.val) {
                return false;
            }

            stack.push(left.left);
            stack.push(right.right);

            stack.push(left.right);
            stack.push(right.left);

        }

        return true;
    }

}
