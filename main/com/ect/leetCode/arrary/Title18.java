package com.ect.leetCode.arrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 4Sum
 *
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d =
 * target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * 思路：求四个数之和等于目标数 1 先对数字进行排序 2 取出剩下三个数等于目标减去第四个数 3 固定第三个数字，两个数字等于目标减去第三第四个数
 *
 * Created by wangjunyu on 17-11-14.
 */
public class Title18 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();

        // 数字进行排序
        Arrays.sort(nums);

        int i = 0;
        while (i < nums.length - 3) {

            List<List<Integer>> threes = threeSum(nums, i + 1, target - nums[i]);

            for (List<Integer> three : threes) {
                three.add(0,nums[i]);
                result.add(three);
            }

            int temp = i;

            i++;

            // 连续两个数相同则跳过
            while (i < nums.length - 3 && nums[i] == nums[temp]) {
                i++;
            }

        }

        return result;

    }

    private static List<List<Integer>> threeSum(int[] nums, int start, int target) {

        List<List<Integer>> result = new ArrayList<>();

        int i = start;

        while (i < nums.length - 2) {
            List<List<Integer>> twos = twoSum(nums, i + 1, target - nums[i]);

            for (List<Integer> two : twos) {
                two.add(0,nums[i]);
                result.add(two);
            }

            int temp = i;

            i++;

            // 连续两个数相同则跳过
            while (i < nums.length - 2 && nums[i] == nums[temp]) {
                i++;
            }
        }

        return result;
    }

    private static List<List<Integer>> twoSum(int[] nums, int start, int target) {

        List<List<Integer>> result = new ArrayList<>();

        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                int temp = right;
                right--;
                while (left < right && nums[right] == nums[temp]) right--;
            } else if (nums[left] + nums[right] < target) {
                int temp = left;
                left++;
                while (left < right && nums[left] == nums[temp]) {
                    left++;
                }
            } else {
                List<Integer> two = new ArrayList<>();
                two.add(nums[left]);
                two.add(nums[right]);
                result.add(two);

                int temp = right;
                right--;

                while (left < right && nums[right] == nums[temp]) right--;
            }
        }

        return result;

    }


    public static void main(String[] args) {

        int[] nums = new int[]{-3,-2,-1,0,0,1,2,3};

        List<List<Integer>> list = fourSum(nums, 0);

        System.out.println("运行结束");

    }


}
