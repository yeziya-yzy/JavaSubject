package day151_160.day158.exercises1;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/11/19
 * 1752. 检查数组是否经排序和轮转得到
 */
class Solution {
    public boolean check(int[] nums) {
        int index = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return true;
        }
        for (int i = index + 1; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                return false;
            }
        }
        return nums[nums.length - 1] <= nums[0];
    }
}