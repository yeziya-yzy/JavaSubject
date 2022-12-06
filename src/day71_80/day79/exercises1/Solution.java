package day79.exercises1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/7/27
 * 1331. 数组序号转换
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().arrayRankTransform(new int[]{
               100,100,100
        })));
    }
    public int[] arrayRankTransform(int[] arr) {
        int[] ints = new int[arr.length];
        int[] temp = new int[arr.length];
        System.arraycopy(arr, 0, temp, 0, temp.length);
        Map<Integer, Integer> integers = new HashMap<>();
        int count = 1;
        Arrays.sort(temp);
        for (int i : temp) {
            if(!integers.containsKey(i)){
                integers.put(i, count);
                count++;
            }
        }
        for (int i = 0; i < ints.length; i++) {
            ints[i] = integers.get(arr[i]);
        }
        return ints;
    }
}
