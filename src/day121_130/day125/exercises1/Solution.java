package day121_130.day125.exercises1;


import java.util.Arrays;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/10/3
 * 1800. 最大升序子数组和
 */
class Solution {
    public int maxAscendingSum(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}