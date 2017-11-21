package com.ect.leetCode.Tree;

/**
 * Convert Sorted Array to Binary Search Tree
 *
 */
public class Title104 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null||nums.length==0) return null;
        return constructBinaryTree(nums,0,nums.length-1);
    }

    private static TreeNode constructBinaryTree(int[] nums, int left, int right){
        if(left>right) return null;

        int middle = (left+right)/2;

        TreeNode middleNode = new TreeNode(nums[middle]);

        middleNode.left = constructBinaryTree(nums,left,middle-1);

        middleNode.right = constructBinaryTree(nums,middle+1,right);

        return middleNode;
    }

}
