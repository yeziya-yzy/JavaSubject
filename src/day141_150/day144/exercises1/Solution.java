package day141_150.day144.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/10/31
 * 754. 到达终点数字
 */
class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int index = 0;
        while (target > 0) {
            index++;
            target -= index;
        }
        if (target % 2 == 0) {
            return index;
        }
        if ((index + 1) % 2 == 1) {
            return index + 1;
        }
        return index + 2;
    }
}