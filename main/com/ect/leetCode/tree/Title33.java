package com.ect.leetCode.tree;

/**
 * Search in Rotated Sorted Array
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return
 * -1.
 *
 * 思路：leetcode 1 找到最小的数，则每个数字的偏移量是最小的数的位置n
 * 2 比如原位置是x的数字，经过便偏移后的位置是（x+n）%数组的长度
 * 3 用双指针
 * You may assume no duplicate exists in the array. Created by wangjunyu on 17-12-8.
 */
public class Title33 {

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        // 寻找最小数，即偏移量
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] < nums[right]) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        int relative = left;

        left = 0;
        right = nums.length - 1;


        while (left <= right) {
            int middle = (left + right) / 2;
            int realMid = (middle + relative) % nums.length;

            if (nums[realMid] == target) return realMid;

            if (nums[realMid] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;

    }

}
