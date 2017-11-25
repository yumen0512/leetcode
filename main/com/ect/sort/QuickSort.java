package com.ect.sort;

/**
 * 快速排序
 * 思想：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
 * 然后再按此方法对这两部分数据分别进行快速排序
 *
 * Created by wangjunyu on 17-11-25.
 */
public class QuickSort {

    private static void quickSort(int[] nums, int left, int right) {

        if (left > right) return;

        int i = partion(nums, left, right);

        quickSort(nums, left, i - 1);

        quickSort(nums, i + 1, right);
    }

    private static int partion(int[] nums, int left, int right) {

        int index = right;
        int quick = left;
        int slow = left - 1;

        while (quick < index) {

            while (quick < index && nums[quick] > nums[index]) quick++;

            if (quick < index) {
                slow++;
                int temp = nums[slow];
                nums[slow] = nums[quick];
                nums[quick] = temp;
                quick++;
            }
        }

        slow++;
        int temp = nums[slow];
        nums[slow] = nums[index];
        nums[index] = temp;

        return slow;

    }


    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 1, 1, 1, 6, 5, -3};
        quickSort(nums, 0, nums.length - 1);
        for (int i : nums) {
            System.out.println(i);
        }
    }


}
