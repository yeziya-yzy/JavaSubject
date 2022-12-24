package day171_180.day177;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/12/13
 * 1753. 移除石子的最大得分
 * 中等
 */
class Solution {
    public int maximumScore(int a, int b, int c) {
        int sum = a + b + c;
        int max = Math.max(Math.max(a, b), c);
        if (sum - max <= max) {
            return sum - max;
        } else {
            return sum / 2;
        }
    }
}