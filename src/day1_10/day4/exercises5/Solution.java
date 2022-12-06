package day4.exercises5;

import java.util.Arrays;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/4/14
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 案例:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 输入: nums = [0]
 * 输出: [0]
 */
class Solution {
    public static void main(String[] args) {
        int[] ints = {1,2,0,3,4};
        moveZeroes(ints);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * for (int i = 0; i < nums.length; i++) {
     * int temp = i;
     * while (temp - 1 >= 0 && nums[temp - 1] == 0) {
     * temp -= 1;
     * }
     * if (temp != i) {
     * nums[temp] = nums[i];
     * nums[i] = 0;
     * }
     * }
     *
     * @param nums 输入的数组
     */
    public static void moveZeroes(int[] nums) {
        int indexLeft = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > indexLeft) {
                    nums[indexLeft] = nums[i];
                    nums[i] = 0;
                }
                indexLeft++;
            }
        }
        // int j = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] != 0) {
        //         if (i > j) {
        //             nums[j] = nums[i];
        //             nums[i] = 0;
        //         }
        //         j++;
        //     }
        // }
    }
}
