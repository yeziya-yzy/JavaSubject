package day3.exercises4;

import java.util.Arrays;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/4/14
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * 案例:
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{-1};
        int k = 3;
        solution.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] temp = new int[k];
        int j = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            temp[j] = nums[i];
            j++;
        }
        int index = nums.length - k - 1;
        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[index];
            index--;
        }
        System.arraycopy(temp, 0, nums, 0, k);
    }
    /**
     * public void rotate(int[] nums, int k) {
     *         int index;
     *         int[] temp = new int[nums.length];
     *         for (int i = 0; i < nums.length; i++) {
     *             index = (i + k) % (nums.length);
     *             temp[index] = nums[i];
     *         }
     *         System.arraycopy(temp, 0, nums, 0, temp.length);
     *     }
     */
}
