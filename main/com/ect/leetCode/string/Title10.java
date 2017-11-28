package com.ect.leetCode.string;

/**
 * Regular Expression Matching
 *
 * Implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character. '*' Matches zero or more of the preceding element.
 *
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab","c*a*b") → true
 */
public class Title10 {

    public static boolean isMatch(String s, String p) {

        if (s == null || p == null) return true;

        return function(s, 0, p, 0);
    }

    /**
     * 思路：递归 1当s,p都到头了，返回true 2当p当天，s未到头返回false
     * 3当后一位是* 4当后一位不是*
     */
    private static boolean function(String s, int i, String p, int j) {

        if (j >= p.length()) {
            if (i >= s.length()) {
                return true;
            }
            return false;
        }

        if ((j+1<p.length()) && '*'==p.charAt(j + 1)) {

            if (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
                return function(s, i + 1, p, j + 2) || function(s, i + 1, p, j) || function(s, i, p, j + 2);
            } else if (i < s.length() && (s.charAt(i) != p.charAt(j))) {
                return function(s, i , p, j + 2);
            } else {
                return function(s, i, p, j + 2);
            }
        } else {
            if (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
                return function(s, i + 1, p, j + 1);
            } else return false;
        }

    }

    public static void main(String[] args) {
        boolean flag = isMatch("aaa","ab*a");
        System.out.println(flag);
    }
}
