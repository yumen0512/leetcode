package com.ect.leetCode.arrary;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * Remove Duplicates from Sorted Array
 *
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and
 * return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array
 * in-place with O(1) extra memory.
 *
 * Example: Given nums = [1,1,2], Your function should return length = 2, with the first two
 * elements of nums being 1 and 2 respectively.
 *
 * It doesn't matter what you leave beyond the new length.
 *
 *
 * 思路：定义两个指针，一块一慢，当快慢相同，快的加1，当快慢不同慢的加1
 */
public class Title26 {

    public int removeDuplicates(int[] nums) {

        if (nums == null) {
            return 0;
        }

        int slow = 0;
        int quick = 0;

        while(quick<nums.length){
            while(quick<nums.length && nums[slow]==nums[quick]){
                quick++;
            }
            if(quick<nums.length){
             slow++;
             nums[slow] = nums[quick];
            }
        }

        return slow+1;
    }
}
