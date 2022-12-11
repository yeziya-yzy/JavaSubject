package day161_170.day169;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/11/30
 * 1827. 最少操作使数组递增
 * 简单
 */
class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1] + 1) {
                count += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }
        return count;
    }
}