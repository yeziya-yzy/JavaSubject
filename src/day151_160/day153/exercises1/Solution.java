package day151_160.day153.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/11/19
 * 1732. 找到最高海拔
 */
class Solution {
    public int largestAltitude(int[] gain) {
        int maxHeight = 0;
        int lastHeight = 0;
        for (int i : gain) {
            lastHeight += i;
            maxHeight = Math.max(maxHeight, lastHeight);
        }
        return maxHeight;
    }
}