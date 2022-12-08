package day161_170.day166;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/11/30
 * 1812. 判断国际象棋棋盘中一个格子的颜色
 * 简单
 */
class Solution {
    public boolean squareIsWhite(String coordinates) {
        int x = coordinates.charAt(0) - 'a' + 1;
        int y = coordinates.charAt(1) - '0';
        if (x % 2 == 1) {
            return y % 2 != 1;
        } else {
            return y % 2 == 1;
        }
    }
}