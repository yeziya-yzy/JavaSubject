package day64.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/6/25
 * 剑指 Offer II 091. 粉刷房子
 */
class Solution {
    public static void main(String[] args) {
        int[][] ints = {
                {17, 2, 17},
                {16, 16, 5},
                {14, 3, 19}
        };
        System.out.println(new Solution().minCost(ints));
    }

    public int minCost(int[][] costs) {
        int length = costs.length;
        int[][] ints = new int[length][3];
        ints[0][0] = costs[0][0];
        ints[0][1] = costs[0][1];
        ints[0][2] = costs[0][2];
        for (int i = 1; i < length; i++) {
            ints[i][0] = costs[i][0] + Math.min(ints[i - 1][1], ints[i - 1][2]);
            ints[i][1] = costs[i][1] + Math.min(ints[i - 1][0], ints[i - 1][2]);
            ints[i][2] = costs[i][2] + Math.min(ints[i - 1][0], ints[i - 1][1]);
        }
        return Math.min(ints[length - 1][0], Math.min(ints[length - 1][1], ints[length - 1][2]));
    }
}
