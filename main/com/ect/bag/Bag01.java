package com.ect.bag;

/**
 * 1.01背包：有n种物品与承重为m的背包。每种物品只有一件，每个物品都有对应的重量weight[i]与价值value[i]，求解如何装包使得价值最大。
 * 2.完全背包：有n种物品与承重为m的背包。每种物品有无限多件，每个物品都有对应的重量weight[i]与价值value[i]，求解如何装包使得价值最大。
 * 3.多重背包：有n种物品与承重为m的背包。每种物品有有限件num[i]，每个物品都有对应的重量weight[i]与价值value[i]，求解如何装包使得价值最大。
 *
 * dp[i][j] 标示将i个物品放入大小为j的背包的价值
 * dp[i][j] = max( dp[i-1][j] , dp[i-1][ j - weight[i] ] + value[i] )
 *
 * dp[j]=max(dp[j],dp[j-weight[i]]+value[i]);
 *
 * 根据动态规划解题步骤（问题抽象化、建立模型、寻找约束条件、判断是否满足最优性原理、找大问题与小问题的递推关系式、
 * 填表、寻找解组成）找出01背包问题的最优解以及解组成，然后编写代码实现
 *
 *
 * Created by Mr Wang :) on 18-1-30.
 */
public class Bag01 {

    void bag01(int[][] nums, int[] weight, int[] values, int capacity) {

        // 把每一个物品尝试放入
        for (int i = 1; i <= weight.length; i++) {

            for (int j = 1; j <= capacity; j++) {
                if (j < weight[i]) {
                    nums[i][j] = nums[i - 1][j];
                } else {
                    nums[i][j] = Math.max(nums[i - 1][j], nums[i - 1][j - weight[i]] + values[i]);
                }
            }
        }
    }

    // dp[j]代表大小j的背包放入最大价值，考虑二维数组时候，每一行的值只和上一行相关，则转成一位数组，在背包重量时候倒叙遍历
    void bag01Bak(int[] nums, int[] weight, int[] values, int capacity) {

        for (int i = 1; i <= weight.length; i++) {

            // 倒叙，前j-1个数据还是上一行数据
            for (int j = capacity; j >= weight[i]; j--) {
                nums[j] = Math.max(nums[j], nums[j - weight[i]] + values[i]);
            }
        }
    }

}
