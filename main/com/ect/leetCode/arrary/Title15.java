package com.ect.leetCode.arrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3Sum
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Created by wangjunyu on 17-11-8.
 *
 * 思路：3sum
 * 1先将数组进行排序
 * 2从左边开始遍历，求剩余两个数之和等于第三个数的相反数
 * 3定于左右两个指针来求两个数之和等于第三个数相反数
 *
 * 时间复杂度 o(n2)
 *
 * 没过的用例
 * [0,0,0,0]
 */
public class Title15 {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return lists;
        }

        // 首先对数组进行排序
        Arrays.sort(nums);

        //从第一个数开始向后便利
        int i = 0;

        int pre = nums[0];
        while (i < nums.length - 2) {

            // 如果和之前的数字一样择跳过
            if (i != 0 && nums[i] == pre) {
                i++;
                continue;
            }

            // 将三树之和改成求两数之和
            int dest = 0 - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] < dest) {
                    left++;
                } else if (nums[left] + nums[right] > dest) {
                    right--;
                } else {
                    List list = new ArrayList();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);

                    // [0,0,0,0] 连续一样的会带来bug通过循环清除
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                }
            }

            pre = nums[i];
            i++;
        }

        return lists;
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{0, 0, 0, 0};
        List<List<Integer>> temp = threeSum(arrays);
    }

}
