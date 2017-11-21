package com.ect.leetCode.Tree;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 * For example,Given n = 3, there are a total of 5 unique BST's.
 *
 * 1         3     3      2      1 \       /     /      / \      \ 3     2     1      1   3      2 /
 * /       \                 \ 2     1         2                 3
 */

/**
 * 思路：Given a sequence 1…n, to construct a Binary Search Tree (BST) out of the sequence,
 * we could enumerate each number i in the sequence, and use the number as the root,
 * naturally,the subsequence 1…(i-1) on its left side would lay on the left branch
 * of the root,and similarly the right subsequence (i+1)…n lay on the right
 * branch of the root.We then can construct the subtree from the subsequence recursively.
 *
 *  G(0)=1, G(1)=1.
 *  F(i, n) = G(i-1) * G(n-i)	1 <= i <= n
 * G(n) = F(1, n) + F(2, n) + ... + F(n, n).
 *
 */
public class Title96 {

    public int numTrees(int n) {

        int[] G = new int[n+1];

        G[0] = G[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] = G[i] + G[j - 1] * G[i - j];
            }
        }

        return G[n];
    }
}
