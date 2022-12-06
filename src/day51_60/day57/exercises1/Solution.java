package day57.exercises1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/6/16
 * 532. 数组中的 k-diff 数对
 */
class Solution {
    public int findPairs(int[] nums, int k) {
        Set<Integer> integers = new HashSet<>();
        Set<Integer> temp = new HashSet<>();
        for (int num : nums) {
            if (temp.contains(k + num)) {
                integers.add(num);
            }
            if (temp.contains(-k + num)) {
                integers.add(-k + num);
            }
            temp.add(num);
        }
        return integers.size();
    }
}
