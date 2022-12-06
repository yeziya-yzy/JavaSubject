package day161_170.day165;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/11/30
 * 1805. 字符串中不同整数的数目
 * 简单
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numDifferentIntegers("a123bc34d8ef34"));
    }

    public int numDifferentIntegers(String word) {
        String[] strings = word.split("[a-zA-z]+");
        Set<String> tempSet = new HashSet<>();
        for (String string : strings) {
            if (string == null || string.length() == 0) {
                continue;
            }
            char[] chars = string.toCharArray();
            int index = -1;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '0') {
                    continue;
                }
                index = i;
                break;
            }
            if (index == -1) {
                tempSet.add("0");
            } else {
                String stringNew = string.substring(index);
                tempSet.add(stringNew);
            }
        }
        return tempSet.size();
    }
}