//package com.ect.leetCode.Tree;
//
//import sun.reflect.generics.tree.Tree;
//
//import java.util.Stack;
//
///**
// * Recover Binary Search Tree
// *
// * Two elements of a binary search tree (BST) are swapped by mistake.
// *
// * Recover the tree without changing its structure.
// *
// * 思路：从根节点开始，找到左右两个misTake，并且标记，交换
// */
//public class Title99 {
//
//    public void recoverTree(TreeNode root) {
//
//        TreeNode error1 = null;
//        TreeNode error2 = null;
//
//        findErrorNode(root, error1, error2);
//
//        if (error1 != null && error2 != null) {
//            int val = error1.val;
//            error1.val = error2.val;
//            error2.val = val;
//        }
//
//    }
//
//    private static void findErrorNode(TreeNode treeNode, TreeNode error1, TreeNode error2) {
//
//        if(treeNode==null) return;
//
//        TreeNode head = treeNode;
//
//        if(treeNode)
//
//        Stack<TreeNode> stack = new Stack<>();
//
//        while(stack!=null || treeNode !=null){
//            while(treeNode.left!=null){
//                stack.push(treeNode);
//                treeNode = treeNode.left;
//            }
//
//
//
//
//        }
//    }
//
//    private static void getIt(TreeNode treeNode, TreeNode error1, TreeNode error2){
//        if(error1==null){
//            error1 = treeNode;
//            return;
//        }
//
//        else{
//            error2 = treeNode;
//        }
//    }
//
//}
