package day131_140.day137.exercises1;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/10/23
 * 915. 分割数组
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().partitionDisjoint(new int[]{
                5, 0, 3, 8, 6
        }));
    }

    public int partitionDisjoint(int[] nums) {
        int length = nums.length;
        int[] minInts = new int[length];
        int max = nums[0];
        int min = nums[length - 1];
        for (int i = length - 1; i >= 0; i--) {
            if (nums[i] <= min) {
                minInts[i] = nums[i];
                min = nums[i];
            } else {
                minInts[i] = min;
            }
        }
        for (int i = 0; i < length; i++) {
            max = Math.max(max, nums[i]);
            if (max <= minInts[i + 1]) {
                return i + 1;
            }
        }
        return max;
    }
}