package com.ect.leetCode.tree;

/**
 * 校验是否是二叉搜索树
 *
 * 二叉搜索树：二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树） 它或者是一棵空树，或者是具有下列性质的二叉树：若它的左子树不空，则左子树上所有
 * 结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值， 且左右子树也是二叉树
 *
 * Validate Binary Search Tree
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key. The right
 * subtree of a node contains only nodes with keys greater than the node's key. Both the left and
 * right subtrees must also be binary search trees.
 *
 * 思路：1判断当前根节点是不是二叉搜索树 2再判断两个子树是不是二叉搜索树
 */
public class Title98 {

    public boolean isValidBST(TreeNode root) {

        if (root == null) return true;

        // 查出左子树是否都小于当前节点
        Integer max = getMaxValue(root.left);

        if (max != null && max >= root.val) return false;

        // 查出右子树是否都大于当前节点
        Integer min = getMinValue(root.right);
        if (min != null && min <= root.val) return false;

        return isValidBST(root.left) && isValidBST(root.right);
    }

    private Integer getMaxValue(TreeNode root) {
        if (root == null) return null;

        Integer left = getMaxValue(root.left);
        Integer right = getMaxValue(root.right);

        int value = root.val;

        if (left != null && left > value) value = left;
        if (right != null && right > value) value = right;

        return value;
    }

    private Integer getMinValue(TreeNode root) {
        if (root == null) return null;

        Integer left = getMinValue(root.left);
        Integer right = getMinValue(root.right);

        int value = root.val;

        if (left != null && left < value) value = left;
        if (right != null && right < value) value = right;

        return value;
    }


    // 思路2 递归比较子树是不是在最大值最小值之前
    public boolean isValidBST2(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
}
