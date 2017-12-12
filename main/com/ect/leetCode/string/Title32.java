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
 * 思路：1用栈记录未匹配的括号位置，然后两两相减找到最大值
 * 2用dp思想，longest(i)定义在i处结尾的最大长度
 * （1）如果s(i)='(' longest(i)=0
 * （2）如果s(i)=')'，如果i-1是'（ 'longest(i) = longest(i-2)+2
 * 如果i-1是')' longest(i-long(i-1)-1)是'(' longest(i-1)+2+long(i-long(i-1)-2)
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
                } else st.push(i);
            }
        }
        if (st.empty()) longest = n;
        else {
            int a = n, b = 0;
            while (!st.empty()) {
                b = st.peek();
                st.pop();
                longest = Math.max(longest, a - b - 1);
                a = b;
            }
            longest = Math.max(longest, a);
        }
        return longest;
    }


    public static int dpSolution(String s) {

        int max = 0;

        int[] longest = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    longest[i] = (i - 2) >= 0 ? longest[i - 2] + 2 : 2;
                } else if (s.charAt(i - 1) == ')' && i - longest[i - 1] - 1 >= 0) {
                    if (s.charAt(i - longest[i - 1] - 1) == '(') {
                        longest[i] = longest[i - 1] + 2 + (i - longest[i - 1] - 2 >= 0 ? longest[i - longest[i - 1] - 2] : 0);
                    }
                }
            }

            if (longest[i] > max) {
                max = longest[i];
            }
        }

        return max;
    }


    public static void main(String[] args) {
        String str = "())";
        System.out.println(dpSolution(str));
    }
}
