package day27.exercises1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/5/8
 * 442. 数组中重复的数据
 */
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int temp = Math.abs(nums[i]);
            if (nums[temp - 1] > 0) {
                nums[temp - 1] = -nums[temp - 1];
            } else {
                integers.add(temp);
            }
        }
        return integers;
    }
}
