package day10.exercises2;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/4/21
 * 你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class Solution {
    public static void main(String[] args) {
        char[][] chars = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '0', '1'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '1'},
        };
        System.out.println(new Solution().numIslands(chars));
    }

    public int numIslands(char[][] grid) {
        boolean[][] booleans = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (booleans[i][j] || grid[i][j] == '0') {
                    continue;
                }
                countNumber(grid, booleans, i, j);
                count++;
            }
        }
        return count;
    }

    public void countNumber(char[][] grid, boolean[][] booleans, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || booleans[x][y] || grid[x][y] == '0') {
            return;
        }
        booleans[x][y] = true;
        countNumber(grid, booleans, x + 1, y);
        countNumber(grid, booleans, x - 1, y);
        countNumber(grid, booleans, x, y + 1);
        countNumber(grid, booleans, x, y - 1);
    }
}
