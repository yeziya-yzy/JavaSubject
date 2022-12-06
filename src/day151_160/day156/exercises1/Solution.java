package day151_160.day156.exercises1;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/11/19
 * 795. 区间子数组个数
 */
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int leftIndex = 0;
        int rightIndex = -1;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                rightIndex = i;
            } else if (nums[i] >= right) {
                leftIndex = i;
                rightIndex = -1;
            }
            if (rightIndex != -1) {
                res += rightIndex - leftIndex;
            }
        }
        return res;
    }
}