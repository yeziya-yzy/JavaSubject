package day151_160.day154.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/11/19
 * 799. 香槟塔
 */
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] before = {poured};
        for (int i = 1; i <= query_row; i++) {
            double[] next = new double[i + 1];
            for (int j = 0; j < i; j++) {
                double aDouble = before[j];
                if (aDouble > 1) {
                    next[j] += (aDouble - 1) / 2;
                    next[j + 1] += (aDouble - 1) / 2;
                }
            }
            before = next;
        }
        return Math.min(before[query_glass], 1);
    }
}