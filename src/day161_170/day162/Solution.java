package day161_170.day162;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/11/30
 * 1779. 找到最近的有相同 X 或 Y 坐标的点
 */
class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x && points[i][1] == y) {
                return i;
            }
            if (points[i][0] == x || points[i][1] == y) {
                int distance = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
                if (distance < min) {
                    min = distance;
                    index = i;
                }
            }
        }
        return index;
    }
}