package com.ect.leetCode.arrary;

/**
 * Longest Palindromic Substring
 *
 * Input: "babad"
 *
 * Output: "bab"
 *
 * 思路：直线思维，定义左右两个指针，遍历所以情况，左右不同进入下一次循环
 *
 * Created by wangjunyu on 17-11-27.
 */
public class Title5 {

    public int start, maxLen;

    public String longestPalindrome(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }

        int i = 0;
        while (i < s.length()) {
            isPalindrome(s, i, i);
            isPalindrome(s, i, i + 1);
            i++;
        }

        return s.substring(start, start + maxLen);
    }

    private void isPalindrome(String s, int left, int right) {

        if (left < 0 || right > s.length() - 1) {
            return;
        }

        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }

        if (right - left - 1 > maxLen) {
            start = left + 1;
            maxLen = right - left - 1;
        }
    }

    public static void main(String[] args) {

        Title5 title5 = new Title5();

        String s = "cbbd";

        String str = title5.longestPalindrome(s);

        System.out.println(str);
    }

}
