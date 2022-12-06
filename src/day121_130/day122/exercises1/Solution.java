package day121_130.day122.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/10/3
 * 921. 使括号有效的最少添加
 */
class Solution {
    public int minAddToMakeValid(String s) {
        int res = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    res++;
                }
            }
        }
        return res + count;
    }
}