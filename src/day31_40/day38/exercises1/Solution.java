package day38.exercises1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/5/20
 * 436. 寻找右区间
 */
class Solution {
    public static void main(String[] args) {
        int[][] ints = new int[][]{
                {4, 5},
                {2, 3},
                {1, 2},
        };
        System.out.println(Arrays.toString(new Solution().findRightInterval(ints)));
    }

    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] startIntervals = new int[n][2];
        int[][] endIntervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            startIntervals[i][0] = intervals[i][0];
            startIntervals[i][1] = i;
            endIntervals[i][0] = intervals[i][1];
            endIntervals[i][1] = i;
        }
        Arrays.sort(startIntervals, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(endIntervals, Comparator.comparingInt(o -> o[0]));

        int[] ans = new int[n];
        for (int i = 0, j = 0; i < n; i++) {
            while (j < n && endIntervals[i][0] > startIntervals[j][0]) {
                j++;
            }
            if (j < n) {
                ans[endIntervals[i][1]] = startIntervals[j][1];
            } else {
                ans[endIntervals[i][1]] = -1;
            }
        }
        return ans;
    }
}
