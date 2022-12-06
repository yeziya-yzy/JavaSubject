package day101_110.day106.exercises1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/9/3
 * 646. 最长数对链
 */
class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        int[] ints = new int[n];
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        Arrays.fill(ints, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    ints[i] = Math.max(ints[i], ints[j] + 1);
                }
            }
        }
        return ints[n - 1];
    }
}
