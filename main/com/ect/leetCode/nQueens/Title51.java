package com.ect.leetCode.nQueens;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such
 * that no two queens attack each other.
 *
 * 思路：递归回溯
 *
 * 判断两个皇后不在一条斜线
 * |y1-y2| ==|x1-x2|
 *
 * Created by wangjunyu on 17-11-23.
 */
public class Title51 {

    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> lists = new ArrayList<>();

        char[][] nums = new char[n][n];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                nums[i][j] = '.';
            }
        }

        dfsSearch(lists, 0, nums);

        return lists;

    }


    private static void dfsSearch(List<List<String>> lists, int row, char[][] nums) {

        if (row == nums.length) {
            buildResult(lists, nums);
            return;
        }


        for (int j = 0; j < nums[0].length; j++) {
            if (validate(nums, row, j)) {
                nums[row][j] = 'Q';
                dfsSearch(lists, row + 1, nums);
                nums[row][j] = '.';
            }
        }


    }


    private static boolean validate(char nums[][], int row, int column) {

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (nums[i][j] == 'Q') {
                    if (column == j || Math.abs(j - column) == Math.abs(i - row)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private static void buildResult(List<List<String>> lists, char[][] nums) {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            String str = new String(nums[i]);
            list.add(str);
        }

        lists.add(list);
    }

    public static void main(String[] args) {
        solveNQueens(4);
    }


}
