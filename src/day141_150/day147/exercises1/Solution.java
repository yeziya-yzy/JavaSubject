package day141_150.day147.exercises1;

import java.util.Arrays;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/11/8
 * 764. 最大加号标志
 */
class Solution {
    public static void main(String[] args) {
        int[][] ints = new int[][]{
                {0, 0},
                {0, 3},
                {1, 1},
                {1, 4},
                {2, 3},
                {3, 0},
                {4, 2}
        };
        System.out.println(new Solution().orderOfLargestPlusSign(5, ints));
    }

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] ints = new int[n][n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ints[i][j] = 1;
            }
        }
        for (int[] mine : mines) {
            ints[mine[0]][mine[1]] = 0;
        }
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k = getK(ints, i, j);
                if (k == 1) {
                    System.out.printf("%d %d\n", i, j);
                }
                if (k == 0) {
                    k = ints[i][j];
                    max = Math.max(max, k);
                } else {
                    max = Math.max(max, k + 1);
                }
            }
        }
        return max;
    }

    private int getK(int[][] tempInts, int x, int y) {
        int length = tempInts.length + 1;
        int temp = 0;
        for (int i = x - 1; i >= 0; i--) {
            if (tempInts[i][y] == 1) {
                temp++;
            } else {
                break;
            }
        }
        if (temp == 0) {
            return 0;
        }
        length = Math.min(length, temp);
        temp = 0;
        for (int i = x + 1; i < tempInts.length; i++) {
            if (tempInts[i][y] == 1) {
                temp++;
            } else {
                break;
            }
        }
        if (temp == 0) {
            return 0;
        }
        length = Math.min(length, temp);
        temp = 0;
        for (int i = y - 1; i >= 0; i--) {
            if (tempInts[x][i] == 1) {
                temp++;
            } else {
                break;
            }
        }
        if (temp == 0) {
            return 0;
        }
        length = Math.min(length, temp);
        temp = 0;
        for (int i = y + 1; i < tempInts[0].length; i++) {
            if (tempInts[x][i] == 1) {
                temp++;
            } else {
                break;
            }
        }
        if (temp == 0) {
            return 0;
        }
        length = Math.min(length, temp);
        return length;
    }
}