package day77.exercises1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/7/18
 * 6120. 数组能形成多少数对
 */
class Solution {
    public static void main(String[] args) {
        for (int number : new Solution().numberOfPairs(new int[]{0})) {
            System.out.println(number);
        }
    }

    public int[] numberOfPairs(int[] nums) {
        int[] ints = new int[2];
        Set<Integer> integers = new HashSet<>();
        for (int num : nums) {
            if (integers.contains(num)) {
                integers.remove(num);
            }else {
                integers.add(num);
            }
        }
        ints[0] = (nums.length - integers.size()) / 2;
        ints[1] = integers.size();
        return ints;
    }
}