package day8.exercises2;


import java.util.Arrays;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/4/18
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * 岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。
 * 你可以假设grid 的四个边缘都被 0（代表水）包围着。
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 * 输入：grid = [[0,0,0,0,0,0,0,0]]
 * 输出：0
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
        };
        System.out.println(solution.maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] booleans = new boolean[grid.length][grid[0].length];
        int temp = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0 || booleans[i][j]) {
                    continue;
                }
                temp = Math.max(temp, getArea(grid, i, j, 0, booleans));
            }
        }
        return temp;
    }

    public int getArea(int[][] grid, int x, int y, int count, boolean[][] booleans) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0 || booleans[x][y]) {
            return 0;
        }
        count = count + 1;
        booleans[x][y] = true;
        getArea(grid, x + 1, y, count, booleans);
        getArea(grid, x - 1, y, count, booleans);
        getArea(grid, x, y + 1, count, booleans);
        getArea(grid, x, y - 1, count, booleans);
        return count;
    }
}
