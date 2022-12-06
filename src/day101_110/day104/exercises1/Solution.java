package day101_110.day104.exercises1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/8/29
 * 998. 最大二叉树 II
 * 1475. 商品折扣后的最终价格
 */
class Solution {
    public int[] finalPrices(int[] prices) {
        int[] ints = new int[prices.length];
        ints[prices.length - 1] = prices[prices.length - 1];
        for (int i = 0; i < prices.length - 1; i++) {
            ints[i] = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    ints[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return ints;
    }
}