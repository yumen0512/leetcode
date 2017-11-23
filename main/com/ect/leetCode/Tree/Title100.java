package com.ect.leetCode.Tree;

/**
 * Same Tree
 *
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical and
 * the nodes have the same value.
 *
 * 思路： 递归判断两个树是不是一样
 *
 * Created by wangjunyu on 17-11-23.
 */
public class Title100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        } else {
            return (isSameTree(p.left, q.left) && (isSameTree(p.right, q.right)));
        }
    }

}
