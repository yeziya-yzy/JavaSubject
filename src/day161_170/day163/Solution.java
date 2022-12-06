package day161_170.day163;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/11/30
 * 1769. 移动所有球到每个盒子所需的最小操作数
 */
class Solution {
    public int[] minOperations(String boxes) {
        int[] res = new int[boxes.length()];
        char[] chars = boxes.toCharArray();
        int left = boxes.charAt(0) - '0';
        int right = 0;
        int startCount = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '1') {
                right++;
                startCount += i;
            }
        }
        res[0] = startCount;
        for (int i = 1; i < chars.length; i++) {
            startCount += left - right;
            res[i] = startCount;
            if (chars[i] == '1') {
                left++;
                right--;
            }
        }
        return res;
    }
}