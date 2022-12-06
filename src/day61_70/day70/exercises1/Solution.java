package day70.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/7/8
 * 1217. 玩筹码
 */
class Solution {
    public int minCostToMoveChips(int[] position) {
        int left = 0;
        int right = 0;
        for (int i : position) {
            if (i % 2 == 0) {
                left++;
            } else {
                right++;
            }
        }
        return Math.min(left, right);
    }
}
