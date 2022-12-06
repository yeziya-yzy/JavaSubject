package day81.exercises1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/8/4
 * 1403. 非递增顺序的最小子序列
 */
class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        List<Integer> res = new ArrayList<>();
        int s = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            s += nums[i];
            res.add(nums[i]);
            if (s > sum - s) {
                break;
            }
        }
        return res;
    }
}
