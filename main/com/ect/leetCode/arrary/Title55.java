package com.ect.leetCode.arrary;

/**
 * Jump Game Given an array of non-negative integers, you are initially positioned at the first
 * index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * For example: A = [2,3,1,1,4], return true.
 *
 * A = [3,2,1,0,4], return false.
 *
 * 每个nums【i】代表可以跳跃的最大长度
 *
 * 思路：贪心算法
 * 记录第i步前能到达的最大位置，如果当前位置大于前几步能到达的最大位置，则认为不可达
 *
 * Created by Mr Wang :) on 17-12-13.
 */
public class Title55 {

    // 遍历所有的情况
    public static boolean canJump(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return true;
        }

        return canJumpFun(nums, 0);
    }


    private static boolean canJumpFun(int[] nums, int start) {

        if (start >= nums.length - 1) {
            return true;
        }

        int jumpStep = nums[start];

        boolean flag = false;

        for (int i = jumpStep; i >= 1; i--) {
            flag = flag || canJumpFun(nums, start + i);
        }

        return flag;

    }

    // 贪心
    public static boolean canJump2(int[] nums) {

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }

        return true;
    }



    public static void main(String[] args) {
        int[] nums = {2, 5, 0, 0};
        System.out.println(canJump(nums));
    }

}
