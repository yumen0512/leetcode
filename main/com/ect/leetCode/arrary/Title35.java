package com.ect.leetCode.arrary;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return
 * the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5 Output: 2 Example 2:
 *
 * Input: [1,3,5,6], 2 Output: 1 Example 3:
 *
 * Input: [1,3,5,6], 7 Output: 4 Example 1:
 *
 * Input: [1,3,5,6], 0 Output: 0
 *
 * Search Insert Position Created by Mr Wang :) on 18-2-5.
 */
public class Title35 {

    public static int searchInsert(int[] nums, int target) {

        return searchInsertWithStart(nums, target, 0, nums.length - 1);
    }

    private static int searchInsertWithStart(int[] nums, int target, int start, int end) {

        int middle = (start + end) / 2;

        if (nums[middle] == target) return middle;

        if (target > nums[end]) return end + 1;

        if (target < nums[start]) return start;

        if (nums[middle] < target) {
            return searchInsertWithStart(nums, target, middle + 1, end);
        } else {
            return searchInsertWithStart(nums, target, start, middle - 1);
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};

        System.out.println(searchInsert(nums,0));
    }

}
