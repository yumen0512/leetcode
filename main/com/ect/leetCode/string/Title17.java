package com.ect.leetCode.string;

import java.util.LinkedList;
import java.util.List;

/**
 * Letter Combinations of a Phone Number
 *
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * Created by Mr Wang :) on 17-12-28.
 */
public class Title17 {


    public static  List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();

        if(digits==null || digits.length()==0) return ans;

        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : mapping[x].toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "123";

        List<String> ans = letterCombinations(s);

    }


}
