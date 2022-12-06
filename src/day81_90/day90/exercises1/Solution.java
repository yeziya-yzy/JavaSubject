package day90.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/8/14
 * 1422. 分割字符串的最大得分
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxScore("01"));
    }

    public int maxScore(String s) {
        int res;
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            res = 0;
            char temp;
            for (int j = 0; j < i; j++) {
                temp = s.charAt(j);
                if (temp == '0') {
                    res++;
                }
            }
            for (int j = i; j < s.length(); j++) {
                temp = s.charAt(j);
                if (temp == '1') {
                    res++;
                }
            }
            max = Math.max(max, res);
        }
        return max;
    }
}
