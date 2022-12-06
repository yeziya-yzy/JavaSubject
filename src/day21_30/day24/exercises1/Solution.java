package day24.exercises1;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/5/5
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 */
class Solution {
    public static void main(String[] args) {
        int[] ints = {10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3};
        int k = 19;
        System.out.println(new Solution().numSubarrayProductLessThanK(ints, k));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int width = 0;
        int temp = 1;
        int count = 0;
        while (width <= nums.length) {
            for (int i = 0; i < nums.length - width; i++) {
                temp = 1;
                for (int j = 0; j <= width; j++) {
                    temp = temp * nums[i + j];
                    if (temp > k) {
                        break;
                    }
                }
                System.out.println(temp);
                if (temp < k) {
                    count += 1;
                }
            }
            width++;
        }
        return count;
    }
}
