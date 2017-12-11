package com.ect.leetCode.string;

import java.util.Stack;

/**
 * Longest Valid Parentheses
 * Given a string containing just the characters '(' and ')', find the
 * length of the longest valid (well-formed) parentheses substring.
 *
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 *
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has
 * length = 4.
 *
 * 思路：1定义一个变量记录总数
 * 2定义两个指针指向（ 和）
 * 3每次找到，不越界的情况下，sum+1
 *
 *
 * Created by Mr Wang :) on 17-12-11.
 */
public class Title32 {
    public static int longestValidParentheses(String s) {

        int n = s.length(), longest = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') st.push(i);
            else {
                if (!st.empty()) {
                    if (s.charAt(st.peek()) == '(') st.pop();
                    else st.push(i);
                }
                else st.push(i);
            }
        }
        if (st.empty()) longest = n;
        else {
            int a = n, b = 0;
            while (!st.empty()) {
                b = st.peek(); st.pop();
                longest = Math.max(longest, a-b-1);
                a = b;
            }
            longest = Math.max(longest, a);
        }
        return longest;
    }


    public static void main(String[] args) {
        String str = ")))(())";
        System.out.println(longestValidParentheses(str));
    }
}
