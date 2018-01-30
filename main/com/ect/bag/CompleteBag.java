package com.ect.bag;

/**
 * 完全背包问题
 * 完全背包是每个物品都无限
 *
 * F[i,v] = max{F[i − 1,v],F[i,v − Ci] + Wi}
 *
 * 如果用一维数组来表示的话，F［v］在左值时表示的是这一阶段的，要保证右面的F［v］是上一阶段的，而F［v－ci］是这一阶段的，所以～顺序计算！！
 *
 * Created by Mr Wang :) on 18-1-30.
 */
public class CompleteBag {


    public void compelete(int[][] nums, int[] weights, int[] values, int capacity) {

        for (int i = 0; i < weights.length; i++) {

            for (int j = weights[i]; j < capacity; j++) {
                for (int k = 0; k * weights[i] < j; k++) {
                    nums[i][j] = Math.max(nums[i - 1][j], nums[i - 1][j - k * weights[i]] + k * values[i]);
                }
            }
        }

    }

    // 完全背包是顺序
    void bagBak(int[] nums, int[] weight, int[] values, int capacity) {

        for (int i = 1; i <= weight.length; i++) {

            // 顺序，背包容量逐渐变大，能放下物品i就放
            for (int j = weight[i]; j <= capacity; j++) {
                nums[j] = Math.max(nums[j], nums[j - weight[i]] + values[i]);
            }
        }
    }


}
