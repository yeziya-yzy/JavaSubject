package day18.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/4/29
 * 给你一个 n * n 矩阵 grid ，矩阵由若干 0 和 1 组成。请你用四叉树表示该矩阵 grid 。
 * 你需要返回能表示矩阵的 四叉树 的根结点。
 * 注意，当 isLeaf 为 False 时，你可以把 True 或者 False 赋值给节点，两种值都会被判题机制 接受 。
 * 四叉树数据结构中，每个内部节点只有四个子节点。此外，每个节点都有两个属性：
 * val：储存叶子结点所代表的区域的值。1 对应 True，0 对应 False；
 * isLeaf: 当这个节点是一个叶子结点时为 True，如果它有 4 个子节点则为 False。
 */
public class Solution {
    public Node construct(int[][] grid) {
        return dfs(grid, 0, 0, grid.length, grid.length);
    }

    public Node dfs(int[][] grid, int r0, int c0, int r1, int c1) {
        boolean same = true;
        for (int i = r0; i < r1; ++i) {
            for (int j = c0; j < c1; ++j) {
                if (grid[i][j] != grid[r0][c0]) {
                    same = false;
                    break;
                }
            }
            if (!same) {
                break;
            }
        }

        if (same) {
            return new Node(grid[r0][c0] == 1, true);
        }

        return new Node(
                true,
                false,
                dfs(grid, r0, c0, (r0 + r1) / 2, (c0 + c1) / 2),
                dfs(grid, r0, (c0 + c1) / 2, (r0 + r1) / 2, c1),
                dfs(grid, (r0 + r1) / 2, c0, r1, (c0 + c1) / 2),
                dfs(grid, (r0 + r1) / 2, (c0 + c1) / 2, r1, c1)
        );
    }
}
