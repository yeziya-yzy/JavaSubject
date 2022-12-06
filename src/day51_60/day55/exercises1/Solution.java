package day55.exercises1;

import java.util.Arrays;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/6/13
 * 1051. 高度检查器
 */
class Solution {
    public int heightChecker(int[] heights) {
        int[] ints = new int[heights.length];
        System.arraycopy(heights, 0, ints, 0, heights.length);
        Arrays.sort(ints);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (ints[i] != heights[i]) {
                res++;
            }
        }
        return res;
    }
}
