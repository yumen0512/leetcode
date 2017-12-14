package com.ect.leetCode.arrary;

/**
 * Jump Game II
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the
 * array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * For example: Given array A = [2,3,1,1,4]
 *
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3
 * steps to the last index.)
 *
 * 思路：I try to change this problem to a BFS problem, where nodes in level i are all the nodes that
 * can be reached in i-1th jump. for example. 2 3 1 1 4 , is 2|| 3 1|| 1 4 ||
 *
 * clearly, the minimum jump of 4 is 2 since 4 is in level 3. my ac code. Note: You can assume that
 * you can always reach the last index. Created by Mr Wang :) on 17-12-13.
 */
public class Title45 {

    public int jump(int[] nums) {

        int levelMax = 0;
        int disMax = 0;
        int step = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            // 找到当前这层跳的最远的
            disMax = Math.max(nums[i] + i, disMax);

            // 是否达到该层最大
            if (levelMax == i) {
                step++;
                levelMax = disMax;
            }
        }

        return step;
    }

}
