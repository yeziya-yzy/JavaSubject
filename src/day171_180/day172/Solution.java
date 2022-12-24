package day171_180.day172;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/12/13
 * 1945. 字符串转化后的各位数字之和
 * 简单
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().getLucky("zbax", 2));
    }

    public int getLucky(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i) - 'a' + 1);
        }

        return getNumber(stringBuilder.toString(), k);
    }

    private int getNumber(String need, int k) {
        if (k == 1) {
            int res = 0;
            for (int i = 0; i < need.length(); i++) {
                res += need.charAt(i) - '0';
            }
            return res;
        }
        int res = 0;
        for (int i = 0; i < need.length(); i++) {
            res += need.charAt(i) - '0';
        }
        return getNumber(String.valueOf(res), k - 1);
    }
}
