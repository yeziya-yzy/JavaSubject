package day151_160.day152.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/11/15
 * 775. 全局倒置与局部倒置
 */
class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int length = nums.length;
        int min = nums[length - 1];
        for (int i = length - 3; i >= 0; i--) {
            if (nums[i] > min) {
                return false;
            }
            min = Math.min(nums[i + 1], min);
        }
        return true;
    }
}
