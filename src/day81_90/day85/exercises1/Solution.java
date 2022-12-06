package day85.exercises1;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/8/9
 * 1413. 逐步求和得到正数的最小值
 */
class Solution {
    public int minStartValue(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
            if (sum < min) {
                min = sum;
            }
        }
        return min >= 1 ? 1 : 1 - sum;
    }
}