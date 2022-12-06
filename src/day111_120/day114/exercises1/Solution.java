package day111_120.day114.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/9/14
 * 1624. 两个相同字符之间的最长子字符串
 */
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i; j--) {
                if (s.charAt(j) == s.charAt(i)) {
                    if (j - i > res) {
                        res = j - i - 1;
                    }
                }
            }
        }
        return res;
    }
}