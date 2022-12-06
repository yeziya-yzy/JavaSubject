package day11.exercises3;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/4/22
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * 案例:
 * 输入：n = 2
 * 输出：[0,1,1]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * <p>
 * 输入：n = 5
 * 输出：[0,1,1,2,1,2]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 * <p>
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.countBits(123);
        System.out.println(Arrays.toString(ints));
    }

    public int[] countBits(int n) {
        int[] ints = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                ints[i] = ints[i - 1] + 1;
            } else {
                ints[i] = ints[i / 2];
            }
        }
        return ints;
    }
}
