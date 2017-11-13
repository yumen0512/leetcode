package com.ect.leetCode.arrary;

import java.util.Arrays;

/**
 * 3Sum Closest
 *
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given
 * number, target. Return the sum of the three integers. You may assume that each input would have
 * exactly one solution
 *
 * 思路，类似于求三个数和最等于0;
 * 1 先排序
 * 2 求两数之和最接近目标数减去第三个数字
 * Created by wangjunyu on 17-11-13.
 */
public class Title16 {

    public static int threeSumClosest(int[] nums, int target) {

        if (nums == null || nums.length < 3) {
            return 0;
        }

        // 第一步先对数字进行排序
        Arrays.sort(nums);

        int minDis = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;

        // 从一个数开始，逐渐取最接近给的数字的值
        for (int i = 0; i < nums.length - 2; i++) {
            int tempMin = function(nums,target-nums[i],i+1);
            if(minDis>Math.abs(target-nums[i]-tempMin)){
                minDis = Math.abs(target-nums[i]-tempMin);
                result = nums[i]+tempMin;
            }
        }

        return result;

    }

    private static int function(int[] nums, int target, int begin) {

        int left = begin;
        int right = nums.length-1;

        int min = Integer.MAX_VALUE;

        int result = Integer.MAX_VALUE;

        while(left<right){

            int minTemp = target-nums[left]-nums[right];

            if(Math.abs(minTemp)<min){
                min = Math.abs(minTemp);
                result = nums[left] + nums[right];
            }

            if(minTemp<0){
                right--;
            }else if(minTemp>0){
                left++;
            }
            else{
                return nums[left] + nums[right];
            }


        }

        return result;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0};
        System.out.println(threeSumClosest(nums,1));
    }
}
