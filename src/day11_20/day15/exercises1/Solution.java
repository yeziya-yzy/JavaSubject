package day15.exercises1;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/4/26
 * 在n x n的网格grid中，我们放置了一些与 x，y，z 三轴对齐的1 x 1 x 1立方体。
 * 每个值v = grid[i][j]表示 v个正方体叠放在单元格(i, j)上。
 * 现在，我们查看这些立方体在 xy、yz和 zx平面上的投影。
 * 投影就像影子，将 三维 形体映射到一个 二维 平面上。从顶部、前面和侧面看立方体时，我们会看到“影子”。
 * 返回 所有三个投影的总面积 。
 */
public class Solution {
    public int projectionArea(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int s1 = 0;
        int s2 = 0;
        int s3 = 0;
        int col;
        int row;
        for (int i = 0; i < grid.length; i++) {
            row = 0;
            col = 0;
            for (int j = 0; j < grid[i].length; j++) {
                s1 += grid[i][j] > 0 ? 1 : 0;
                row = Math.max(grid[i][j], row);
                col = Math.max(grid[j][i], col);
            }
            s2 += row;
            s3 += col;
        }
        return s1 + s2 + s3;
    }
}
