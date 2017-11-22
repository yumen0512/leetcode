package com.ect.leetCode.greedy;

/**
 * Is Subsequence Given a string s and a string t, check if s is subsequence of t.
 *
 * 思路：设置两个指针，比较s和t是否相同，当相同，判断s是否到头，到头返回true，没到头比较下一位
 */
public class Title392 {

    public boolean isSubsequence(String s, String t) {

        if (s == null || t == null) {
            return false;
        }

        if (s.length() == 0) {
            return true;
        }

        if(t.length()==0){
            return false;
        }

        char[] chars = s.toCharArray();

        return isSub(0, 0, chars, t);

    }

    private static boolean isSub(int start, int tStart, char[] chars, String t) {

        if (tStart > t.length()) return false;

        if (start == (chars.length - 1)) {
            if (t.indexOf(chars[start], tStart) == -1) {
                return false;
            } else {
                return true;
            }
        }

        int nextTStart = t.indexOf(chars[start], tStart);

        if (nextTStart == -1) {
            return false;
        }

        start++;
        nextTStart++;
        return isSub(start, nextTStart, chars, t);

    }

    public boolean isSubsequence2(String s, String t) {
        if (s.length() == 0) return true;
        int indexS = 0, indexT = 0;
        while (indexT < t.length()) {
            if (t.charAt(indexT) == s.charAt(indexS)) {
                indexS++;
                if (indexS == s.length()) return true;
            }
            indexT++;
        }
        return false;
    }


}
