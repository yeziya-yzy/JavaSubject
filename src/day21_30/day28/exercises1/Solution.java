package day28.exercises1;

import java.util.Arrays;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/5/9
 * 942. 增减字符串匹配
 */
class Solution {
    public static void main(String[] args) {
        String s = "DDI";
        System.out.println(Arrays.toString(new Solution().diStringMatch(s)));
    }

    public int[] diStringMatch(String s) {
        int[] ints = new int[s.length() + 1];
        int max = s.length();
        int min = 0;
        for (int i = 0; i < s.length(); i++) {
            ints[i] = (s.charAt(i) == 'I' ? min-- : max--);
        }
        ints[s.length()] = max;
        return ints;
    }
}