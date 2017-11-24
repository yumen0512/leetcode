package com.ect.leetCode.arrary;

/**
 * ZigZag Conversion
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 *
 * 思路：模仿z字打印，先打印竖的一行，再循环打印上升的一行
 * Created by wangjunyu on 17-11-24.
 */
public class Title6 {

    public static String convert(String s, int numRows) {

        if (s == null) {
            return null;
        }

        StringBuffer[] sbs = new StringBuffer[numRows];

        for (int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuffer();
        }

        char[] chars = s.toCharArray();

        int index = 0;

        int row;

        int size = chars.length;
        while (index < size) {
            for (row = 0; index < size && row < numRows; row++) {
                sbs[row].append(chars[index++]);
            }

            for (row = numRows - 2; index < size && row >= 1; row--) {
                sbs[row].append(chars[index++]);
            }
        }

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < sbs.length; i++) {
            sb = sb.append(sbs[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        convert("PAYPALISHIRING", 3);
    }

}
