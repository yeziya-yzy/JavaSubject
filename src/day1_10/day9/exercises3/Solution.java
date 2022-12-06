package day9.exercises3;

import java.util.Arrays;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/4/20
 * 给定一个由 0 和 1 组成的矩阵 mat，
 * 请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 * 两个相邻元素间的距离为 1
 * 案例:
 * 输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：[[0,0,0],[0,1,0],[0,0,0]]
 * <p>
 * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
 * 输出：[[0,0,0],[0,1,0],[1,2,1]]
 */
public class Solution {
    public static void main(String[] args) {
        int[][] ints = {
                {1, 0, 0},
                {1, 1, 0},
                {1, 1, 1},
        };
        System.out.println(Arrays.deepToString(new Solution().updateMatrix(ints)));
    }

    public int[][] updateMatrix(int[][] mat) {
        int temp;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] != 0) {
                    temp = 2;
                    if (i - 1 >= 0) {
                        temp = Math.min(temp, mat[i - 1][j]);
                    }
                    if (i + 1 < mat.length) {
                        temp = Math.min(temp, mat[i + 1][j]);
                    }
                    if (j - 1 >= 0) {
                        temp = Math.min(temp, mat[i][j - 1]);
                    }
                    if (j + 1 < mat[0].length) {
                        temp = Math.min(temp, mat[i][j + 1]);
                    }
                    System.out.println(temp);
                    mat[i][j] = temp + 1;
                }
            }
        }
        return mat;
    }

    public void countStep(int[][] mat, int x, int y, int count) {
        if (x < 0 || y < 0 || x >= mat.length || y >= mat[0].length || mat[x][y] == 0 || mat[x][y] < count) {
            return;
        }
        count++;
        mat[x][y] = count;
        countStep(mat, x - 1, y, count);
        countStep(mat, x + 1, y, count);
        countStep(mat, x, y - 1, count);
        countStep(mat, x, y + 1, count);
    }
}
