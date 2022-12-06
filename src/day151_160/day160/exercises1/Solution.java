package day151_160.day160.exercises1;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/11/19
 * 1758. 生成交替二进制字符串的最少操作数
 */
class Solution {
    public int minOperations(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != (char) ('0' + i % 2)) {
                cnt++;
            }
        }
        return Math.min(cnt, s.length() - cnt);
    }
}