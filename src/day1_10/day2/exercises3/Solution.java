package day2.exercises3;

import java.util.Arrays;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/4/12
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序
 * 示例
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(solution.sortedSquares(ints)));
    }

    public int[] sortedSquares(int[] nums) {
        if (nums[0] >= 0) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = nums[i] * nums[i];
            }
            return nums;
        }
        if (nums[nums.length - 1] <= 0) {
            int[] temp = new int[nums.length];
            for (int i = nums.length - 1, j = 0; i >= 0; i--, j++) {
                temp[j] = nums[i] * nums[i];
            }
            nums = temp;
            return nums;
        }
        int index;
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                index = i;
                left = index - 1;
                right = index;
                break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        int temp = 0;
        int[] tempArr = new int[nums.length];
        while (left >= 0 && right < nums.length) {
            if (nums[left] <= nums[right]) {
                tempArr[temp] = nums[left];
                left--;
            } else {
                tempArr[temp] = nums[right];
                right++;
            }
            temp++;
        }
        while (left >= 0) {
            tempArr[temp] = nums[left];
            left--;
            temp++;
        }
        while (right < nums.length) {
            tempArr[temp] = nums[right];
            right++;
            temp++;
        }
        nums = tempArr;
        return nums;
    }
}
