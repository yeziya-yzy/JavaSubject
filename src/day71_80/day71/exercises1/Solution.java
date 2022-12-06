package day71.exercises1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/7/9
 * 873. 最长的斐波那契子序列的长度
 */
class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0 && arr[j] * 2 > arr[i]; j--) {
                int k = map.getOrDefault(arr[i] - arr[j], -1);
                if (k >= 0) {
                    dp[j][i] = Math.max(dp[k][j] + 1, 3);
                    res = Math.max(res, dp[j][i]);
                }
            }
        }
        return res;
    }
}
