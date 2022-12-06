package day161_170.day164;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/11/30
 * 1796. 字符串中第二大的数字
 */
class Solution {
    public int secondHighest(String s) {
        int max = -1;
        int nextManx = -1;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar >= '0' && aChar <= '9') {
                if (aChar - 48 > max) {
                    nextManx = max;
                    max = aChar - 48;
                } else if (aChar - 48 < max && aChar - 48 > nextManx) {
                    nextManx = aChar - 48;
                }
            }
        }
        return nextManx;
    }
}