package com.ect.leetCode.arrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Group Anagrams
 * Given an array of strings, group anagrams together.
 *
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 *
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 *
 * 思路：1 将数组进行排序
 *      2 将输入string 转义成按字符升序的map key
 *      3 在map中查询
 *      4 转义输出
 * Created by wangjunyu on 17-12-5.
 */
public class Title49 {

    public List<List<String>> groupAnagrams(String[] strs) {

        // 首先将数组排序
        Arrays.sort(strs);

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            String key = sortStr(str);

            if (map.containsKey(key)) {
                List<String> list = map.get(key);
                list.add(str);
                map.put(key, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }

        return new ArrayList<>(map.values());

    }

    private static String sortStr(String str) {

        char[] chars = str.toCharArray();

        Arrays.sort(chars);

        String keyStr = String.valueOf(chars);

        return keyStr;
    }

}
