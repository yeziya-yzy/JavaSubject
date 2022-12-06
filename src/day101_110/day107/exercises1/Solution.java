package day101_110.day107.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/9/3
 * 1582. 二进制矩阵中的特殊位置
 */
class Solution {
    public int numSpecial(int[][] mat) {
        int res = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1 && isSpecialPosition(mat, i, j)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean isSpecialPosition(int[][] ints, int x, int y) {
        int[] anInt = ints[x];
        for (int i = 0; i < anInt.length; i++) {
            if (anInt[i] == 1 && i != y) {
                return false;
            }
        }
        for (int i = 0; i < ints.length; i++) {
            if (ints[i][y] == 1 && i != x) {
                return false;
            }
        }
        return true;
    }
}
