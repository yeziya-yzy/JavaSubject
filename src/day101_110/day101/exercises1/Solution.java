package day100_110.day101.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/8/29
 * 1470. 重新排列数组
 */
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ints = new int[nums.length];
        int indexLeft = 0;
        int indexRight = n;
        for (int i = 0; i < nums.length; i += 2) {
            ints[i] = nums[indexLeft++];
            ints[i + 1] = nums[indexRight++];
        }
        return ints;
    }
}
