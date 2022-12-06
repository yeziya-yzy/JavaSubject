package day42.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/5/25
 * 467. 环绕字符串中唯一的子字符串
 */
class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int k = 0;
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i) - p.charAt(i - 1) == -25)) {
                k++;
            } else {
                k = 1;
            }
            dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], k);
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res += dp[i];
        }
        return res;
    }
}
