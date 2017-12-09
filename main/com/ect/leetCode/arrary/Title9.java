package com.ect.leetCode.arrary;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * Created by Mr Wang :) on 17-12-9.
 */
public class Title9 {

    public boolean isPalindrome(int x) {

        String str = String.valueOf(x);

        char[] chars = str.toCharArray();

        int left = 0;
        int right = chars.length - 1;

        while (left <= right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    /**
     * 判断一个数是不是回文数
     * 将x分成前后两部分，如果前后两部分相同，或者前部分等于后部分/10(奇数)
     * 则认为是回数
     */
    public static boolean isPalindrome2(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int sum = 0;
        while (x > sum) {
            sum = sum * 10 + x % 10;
            x = x / 10;
        }
        return (x == sum) || (x == sum / 10);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome2(23132));
    }

}
