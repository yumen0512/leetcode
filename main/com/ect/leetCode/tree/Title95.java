package com.ect.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees)
 * that store values 1...n.
 *
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 *
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 *
 * 思路：递归,从1到n选取个数i，则1到i-1在左侧，i+1到n在右侧，递归找到所有可能
 *
 * Created by wangjunyu on 17-12-6.
 */
public class Title95 {

    public List<TreeNode> generateTrees(int n) {

        if (n == 0) return new ArrayList<>();

        return buildAllBTSTree(1, n);
    }

    private List<TreeNode> buildAllBTSTree(int start, int end) {

        List<TreeNode> treeNodes = new ArrayList<>();

        if (start > end) {
            treeNodes.add(null);
            return treeNodes;
        }

        if (start == end) {
            TreeNode treeNode = new TreeNode(start);
            treeNodes.add(treeNode);
            return treeNodes;
        }


        for (int i = start; i <= end; i++) {
            List<TreeNode> left = buildAllBTSTree(start, i - 1);
            List<TreeNode> right = buildAllBTSTree(i + 1, end);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = l;
                    treeNode.right = r;
                    treeNodes.add(treeNode);
                }
            }
        }

        return treeNodes;
    }
}
