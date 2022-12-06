package day56.exercises1;

import java.util.Arrays;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/6/14
 * 498. 对角线遍历
 */
class Solution {
    public static void main(String[] args) {
        int[][] ints = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        System.out.println(Arrays.toString(new Solution().findDiagonalOrder(ints)));
    }

    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length * mat[0].length;
        int[] ints = new int[n];
        int index = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0) {
                while (x >= 0 && y >= 0 && x < mat.length && y < mat[0].length) {
                    ints[index] = mat[x][y];
                    x--;
                    y++;
                    index++;
                }
                if (y < mat[0].length) {
                    x++;
                } else {
                    x += 2;
                    y--;
                }
            } else {
                while (x >= 0 && y >= 0 && x < mat.length && y < mat[0].length) {
                    ints[index] = mat[x][y];
                    x++;
                    y--;
                    index++;
                }
                if (x < mat.length) {
                    y++;
                } else {
                    y += 2;
                    x--;
                }
            }
        }
        return ints;
    }
}
