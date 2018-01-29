package com.ect.sort;

/**
 * 合并排序
 * Created by Mr Wang :) on 18-1-29.
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] nums = new int[]{5, 3, 2, 1, 4};

        mergeSort(nums, 0, nums.length - 1);

        for (int i : nums) {
            System.out.println(i);
        }


    }

    public static void mergeSort(int[] nums, int start, int end) {

        if (start >= end) return;

        int middle = (start + end) / 2;

        mergeSort(nums, start, middle);

        mergeSort(nums, middle + 1, end);

        // 合并两个排序好的数组
        int[] temp = new int[end - start + 1];

        int left = start;

        int right = middle + 1;

        int i = 0;

        while (left <= middle && right <= end) {

            if (nums[left] < nums[right]) {
                temp[i++] = nums[left++];
            } else {
                temp[i++] = nums[right++];
            }
        }

        if (left > middle && right <= end) {
            while (right <= end) {
                temp[i++] = nums[right++];
            }
        }

        if (right > end && left <= middle) {
            while (left <= middle) {
                temp[i++] = nums[left++];
            }
        }

        int j = 0;

        for (i = start; i <= end; i++) {
            nums[i] = temp[j++];
        }


    }

}
