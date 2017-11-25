package com.ect.leetCode.arrary;

import java.util.ArrayList;

/**
 * Reverse Integer
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Input: 123
 * Output:  321
 *
 * Input: 120
 * Output: 21
 * Created by wangjunyu on 17-11-24.
 */
public class Title7 {

    private static int reverse(int x) {

        boolean flag = false;

        if (x < 0) {
            flag = true;
        }

        int y = Math.abs(x);

        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(0);

        while (y != 0) {
            int num = y % 10;
            arrayList.add(num);
            y = y / 10;
        }


        StringBuilder sb = new StringBuilder();


        if (flag) {
            sb.append("-");
        }

        arrayList.forEach(p -> sb.append(p));

        int result = 0;
        try {
            result = Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            System.out.println(x);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

}
