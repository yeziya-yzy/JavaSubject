package day171_180.day176;

import java.util.Arrays;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/12/13
 * 1760. 袋子里最少数目的球
 * 中等
 */
class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int res = 0;
        int right = Arrays.stream(nums).max().getAsInt();
        int left = 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            long ops = 0;
            for (int num : nums) {
                ops += (num - 1) / mid;
            }
            if (ops <= maxOperations) {
                right = mid - 1;
                res = mid;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}