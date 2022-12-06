package day12.exercises1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/4/23
 * 在一个二维的花园中，有一些用 (x, y) 坐标表示的树。
 * 由于安装费用十分昂贵，你的任务是先用最短的绳子围起所有的树。
 * 只有当所有的树都被绳子包围时，花园才能围好栅栏。你需要找到正好位于栅栏边界上的树的坐标。
 */
public class Solution {
    public static void main(String[] args) {
        int[][] ints = new int[][]{
                {1, 1},
                {2, 2},
                {2, 0},
                {2, 4},
                {3, 3},
                {4, 2},
        };
        System.out.println(Arrays.deepToString(new Solution().outerTrees(ints)));
    }

    public int[][] outerTrees(int[][] trees) {
        int n = trees.length;
        if (n < 4) {
            return trees;
        }
        int leftMost = 0;
        for (int i = 0; i < n; i++) {
            if (trees[i][0] < trees[leftMost][0]) {
                leftMost = i;
            }
        }
        List<int[]> res = new ArrayList<>();
        boolean[] visit = new boolean[n];
        int start = leftMost;
        do {
            int change = (start + 1) % trees.length;
            for (int i = 0; i < trees.length; i++) {
                if (cross(trees[start], trees[change], trees[i]) < 0) {
                    change = i;
                }
            }
            for (int i = 0; i < trees.length; i++) {
                if (visit[i] || i == start || i == change) {
                    continue;
                }
                if (cross(trees[start], trees[change], trees[i]) == 0) {
                    res.add(trees[i]);
                    visit[i] = true;
                }
            }
            if (!visit[change]) {
                res.add(trees[change]);
                visit[change] = true;
            }
            start = change;
        } while (start != leftMost);
        return res.toArray(new int[][]{});
    }

    public int cross(int[] p, int[] q, int[] r) {
        return (q[0] - p[0]) * (r[1] - q[1]) - (q[1] - p[1]) * (r[0] - q[0]);
    }

    private boolean ifLeft(int x1, int y1, int x2, int y2, int a, int b) {
        if (x1 == x2) {
            return b <= x1;
        }
        return b >= (y2 - y1) / (x2 - x1) * (a - x1) + y1;
    }

    // private boolean ifCollinear(int x, int y, int a, int b) {
    //     if (x == a) {
    //         return true;
    //     } else {
    //         return
    //     }
    // }
}
