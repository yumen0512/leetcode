package com.ect.leetCode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 思路：1递归
 *      2 用堆栈
 */
public class Title94 {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        inOrder(root,list);
        return list;
    }

    private static void inOrder(TreeNode root,List<Integer> list){
        if(root==null) return;

        if(root.left!=null){
            inOrder(root.left,list);
        }

        list.add(root.val);

        if(root.right!=null){
            inOrder(root.right,list);
        }
    }

    public List<Integer> inorderTraversal2(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            list.add(root.val);
            root = root.right;

        }

        return list;
    }

}
