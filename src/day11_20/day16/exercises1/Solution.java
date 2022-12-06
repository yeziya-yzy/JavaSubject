package day16.exercises1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/4/27
 * 有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。
 * “太平洋”处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
 * 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵heights，
 * heights[r][c]表示坐标 (r, c) 上单元格 高于海平面的高度 。
 * 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。
 * 水可以从海洋附近的任何单元格流入海洋。
 * 返回 网格坐标 result的 2D列表 ，其中result[i] = [ri, ci]表示雨水可以从单元格 (ri, ci) 流向 太平洋和大西洋
 */
public class Solution {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        int[][] ints = new int[][]{
                // {1, 2, 2, 3, 5},
                // {3, 2, 3, 4, 4},
                // {2, 4, 5, 3, 1},
                // {6, 7, 1, 4, 5},
                // {5, 1, 1, 2, 4}
                {1, 1},
                {1, 1},
                {1, 1},
        };
        List<List<Integer>> lists = new Solution().pacificAtlantic(ints);
        for (List<Integer> list : lists) {
            Object[] objects = list.toArray();
            System.out.println(Arrays.toString(objects));
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        boolean[][] booleans = new boolean[heights.length][heights[0].length];
        boolean[][] booleansNew = new boolean[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            getWhere(heights, i, 0, booleans);
        }
        for (int i = 0; i < heights[0].length; i++) {
            getWhere(heights, 0, i, booleans);
        }
        for (int i = 0; i < heights.length; i++) {
            getWhere(heights, i, heights[0].length - 1, booleansNew);
        }
        for (int i = 0; i < heights[0].length; i++) {
            getWhere(heights, heights.length - 1, i, booleansNew);
        }
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (booleans[i][j] && booleansNew[i][j]) {
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(i);
                    integers.add(j);
                    lists.add(integers);
                }
            }
        }
        return lists;
    }

    public void getWhere(int[][] heights, int x, int y, boolean[][] booleans) {
        if (booleans[x][y]) {
            return;
        }
        booleans[x][y] = true;
        int newX;
        int newY;
        for (int[] dir : dirs) {
            newX = x + dir[0];
            newY = y + dir[1];
            if (newX >= 0 && newY >= 0 && newX < heights.length && newY < heights[0].length && heights[newX][newY] >= heights[x][y]) {
                getWhere(heights, newX, newY, booleans);
            }
        }
    }
}
