package day53.exercises1;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/6/11
 */
class Solution {
    public static void main(String[] args) {
        String s = "0101100011";
        System.out.println(new Solution().minFlipsMonoIncr(s));
    }

    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int dp0 = 0, dp1 = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int dp0New = dp0, dp1New = Math.min(dp0, dp1);
            if (c == '1') {
                dp0New++;
            } else {
                dp1New++;
            }
            dp0 = dp0New;
            dp1 = dp1New;
        }
        return Math.min(dp0, dp1);
    }
}
