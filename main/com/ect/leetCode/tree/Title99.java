package com.ect.leetCode.tree;

/**
 * Recover Binary Search Tree
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 *
 * 思路：bts二叉树的中序遍历是从小到大的，有问题的节点必然是出现逆序的
 */
public class Title99 {

    private TreeNode firstNode = null;
    private TreeNode secondNode = null;
    private TreeNode beforeNode = new TreeNode(Integer.MIN_VALUE);


    public void recoverTree(TreeNode root){

        recoverTreeFunction(root);

        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }


    public  void recoverTreeFunction(TreeNode root) {

        if (root == null) return;

        recoverTreeFunction(root.left);

        // If first element has not been found, assign it to prevElement (refer to 6 in the example above)
        if (firstNode == null && root.val < beforeNode.val) {
            firstNode = beforeNode;
        }

        // If first element is found, assign the second element to the root (refer to 2 in the example above)
        if (firstNode != null && root.val < beforeNode.val) {
            secondNode = root;
        }

        beforeNode = root;

        recoverTreeFunction(root.right);

    }

}
