package com.ect.leetCode.arrary;

/**
 * Remove Element
 * Given nums = [3,2,2,3], val = 3,
 *
 * 思路：1定义i，j两个指针，i指向的都是val,j指向都是不等于val
 *      2j从0指到n，当nums[j]和val不同，i右移动
 *
 * Created by wangjunyu on 17-11-29.
 */
public class Title27 {

    public static int removeElement(int[] nums, int val) {

        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }

        return i;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3};
        System.out.println(removeElement(nums, 5));
    }

}
