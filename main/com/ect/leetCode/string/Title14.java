package com.ect.leetCode.string;

/**
 * Longest Common Prefix
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 * Created by wangjunyu on 17-11-30.
 */
public class Title14 {

    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) return "";

        String commonPrefix = strs[0];

        for (int i = 0; i < strs.length; i++) {
            if (i == 0) {
                continue;
            }

            String str = strs[i];

            int min = Math.min(str.length(),commonPrefix.length());

            if(str.length()>min){
                str = str.substring(0,min);
            }

            if(commonPrefix.length()>min){
                commonPrefix = commonPrefix.substring(0,min);
            }

            for (int k = 0; k < min; k++) {
                if (str.charAt(k) != commonPrefix.charAt(k)) {
                    if(k==0) return "";
                    commonPrefix = commonPrefix.substring(0, k);
                    break;
                }
            }

        }

        return commonPrefix;
    }

    public static void main(String[] args) {
        String str1 = "ca";
        String str2 = "a";

        String[] strings = {str1,str2};

        longestCommonPrefix(strings);
    }
}
