package com.ect.leetCode.arrary;

import java.util.Arrays;

/**
 * Next Permutation
 *
 * 1,2,3 → 1,3,2 3,2,1 → 1,2,3 1,1,5 → 1,5,1
 *
 * 思路： 1从后开始，找到最后一个生序位置,认为该位置i以后的都已经降序了 2从已排序的数中，找到最小的比i大的数字k，交换两数位置 3将i后的数字按生序排列
 */
public class Title31 {

    public static void nextPermutation(int[] nums) {

        int i = -1;

        for (int j = nums.length - 1; j >= 1; j--) {
            if (nums[j - 1] < nums[j]) {
                i = j - 1;
                break;
            }
        }

        if (i == -1) {
            Arrays.sort(nums);
            return;
        }

        int k = -1;
        for (int j = nums.length - 1; j > i; j--) {
            if (nums[j] > nums[i]) {
                k = j;
                break;
            }
        }

        if (k == -1) return;

        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;

        Arrays.sort(nums, i + 1, nums.length);
        return;

    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        nextPermutation(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }

}
