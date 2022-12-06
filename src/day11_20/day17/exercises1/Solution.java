package day17.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/4/28
 * 给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。
 * 返回满足此条件的 任一数组 作为答案。
 * 输入：nums = [3,1,2,4]
 * 输出：[2,4,3,1]
 * 解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
 */
public class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int index = 0;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                if (i > index) {
                    temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                }
                index++;
            }
        }
        return nums;
    }
}
