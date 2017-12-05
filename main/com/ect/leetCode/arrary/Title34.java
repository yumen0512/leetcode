package com.ect.leetCode.arrary;

/**
 * Search for a Range Given an array of integers sorted in ascending order, find the starting and
 * ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 *
 * 找到目标数出现的位置
 *
 * Created by wangjunyu on 17-12-5.
 */
public class Title34 {

    public static int[] searchRange(int[] nums, int target) {

        if (nums.length == 0) return new int[]{-1, -1};

        int left = 0;
        int right = nums.length - 1;
        while (left <= right && (nums[left] < target || nums[right] > target)) {
            if (nums[left] < target) {
                left++;
            }
            if (nums[right] > target) {
                right--;
            }
        }

        if (right < left || (nums[left] != target || nums[right] != target)) {
            return new int[]{-1, -1};
        }

        return new int[]{left, right};

    }


    public static int[] searchRange2(int[] nums, int target) {
        int[] result = {-1, -1};

        // 查找左边界
        int i = 0, j = nums.length - 1;

        while (i < j) {

            int middle = (i + j) / 2;
            if (nums[middle] < target) {
                i = middle + 1;
            } else {
                j = middle;
            }
        }

        if (nums[i] != target) return result;

        j = nums.length - 1;

        result[0] = i;

        while (i < j) {

            int middle = (i + j) / 2 + 1;
            if (nums[middle] > target) {
                j = middle - 1;
            } else {
                i = middle;
            }
        }
        if (nums[i] != target) return result;

        result[1] = j;

        return nums;

    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        searchRange2(nums, target);
    }
}
