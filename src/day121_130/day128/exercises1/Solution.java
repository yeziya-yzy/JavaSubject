package day121_130.day128.exercises1;

import java.util.Arrays;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/10/3
 * 1790. 仅执行一次字符串交换能否使两个字符串相等
 */
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int n = s1.length();
        int count = 0;
        int indexLeft = 0;
        boolean flag = true;
        int indexRight = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (flag) {
                    indexLeft = i;
                    flag = false;
                } else {
                    indexRight = i;
                }
            }
            if (count > 2) {
                return false;
            }
        }
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        char temp;
        temp = s2Chars[indexLeft];
        s2Chars[indexLeft] = s2Chars[indexRight];
        s2Chars[indexRight] = temp;
        return Arrays.equals(s1Chars, s2Chars);
    }
}