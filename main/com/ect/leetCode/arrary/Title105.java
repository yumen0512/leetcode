package com.ect.leetCode.arrary;


/**
 * Construct Binary Tree from Preorder and Inorder Traversal
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * 思路：1 从前序的根节点开始，根据在中序遍历的位置，来判断左右节点的位置。当相应位置为null，则插入
 * 2 从前序的根节点开始，根据在中序遍历的位置，将树分成左右两个子树，递归调用
 *
 * Created by wangjunyu on 17-11-15.
 */
public class Title105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        return buildTreeNode(0, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode buildTreeNode(int preStart, int inStart, int inEnd, int[] preOrder, int[] inOrder) {

        if (preStart > preOrder.length - 1 || inStart > inEnd) {
            return null;
        }

        int rootValue = preOrder[preStart];

        int rootLocal = 0;

        // 找到root位置
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == rootValue) {
                rootLocal = i;
                break;
            }
        }

        TreeNode treeNode = new TreeNode(rootValue);

        treeNode.left = buildTreeNode(preStart + 1, inStart, rootLocal - 1, preOrder, inOrder);
        treeNode.right = buildTreeNode(preStart + rootLocal - inStart +1, rootLocal + 1, inEnd, preOrder, inOrder);

        return treeNode;
    }

    public static void main(String[] args) {

    }

}
