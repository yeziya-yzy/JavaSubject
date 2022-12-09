package day161_170.day167;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/11/30
 * 1780. 判断一个数字是否可以表示成三的幂的和
 * 中等
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().checkPowersOfThree(12));
    }

    public boolean checkPowersOfThree(int n) {
        int res = n;
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0) {
            stringBuilder.insert(0, n - n / 3 * 3);
            n = n / 3;
        }
        char[] chars = stringBuilder.toString().toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                continue;
            }
            sum += Math.pow(3, chars.length - 1 - i);
        }
        return sum == res;
    }
}