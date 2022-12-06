package day73.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/7/12
 * 1252. 奇数值单元格的数目
 */
class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] ints = new int[m][n];
        int res = 0;
        for (int[] index : indices) {
            for (int i = 0; i < n; i++) {
                ints[index[0]][i]++;
            }
            for (int i = 0; i < m; i++) {
                ints[i][index[1]]++;
            }
        }
        for (int[] anInt : ints) {
            for (int i : anInt) {
                if (i % 2 == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}
