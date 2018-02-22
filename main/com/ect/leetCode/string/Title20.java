package com.ect.leetCode.string;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
 * input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]"
 * are not.
 *
 * Created by Mr Wang :) on 18-2-22.
 */
public class Title20 {

    public static boolean isValid(String s) {

        if (s.length() % 2 == 1) return false;

        Stack<Character> left = new Stack<>();

        Stack<Character> right = new Stack<>();

        for (char c : s.toCharArray()) {
            left.push(c);
        }

        while (!left.isEmpty()) {
            if (right.isEmpty()) {
                char c = left.pop();
                right.push(c);
            }

            if ((left.peek() == '(' && right.peek() == ')') || (left.peek() == '[' && right.peek() == ']') ||
                    (left.peek() == '{') && right.peek() == '}') {
                left.pop();
                right.pop();
            } else {
                char c = left.pop();
                right.push(c);
            }

        }

        if (right.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid2("([)]"));
    }



}
