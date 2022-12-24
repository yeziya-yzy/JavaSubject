package day171_180.day175;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/12/13
 * 1971. 寻找图中是否存在路径
 * 简单
 */
class Solution {
    private int[] pre;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }
        pre = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] = i;
        }
        for (int[] edge : edges) {
            pre[find(edge[0])] = find(edge[1]);
        }
        return find(source) == find(destination);
    }

    private int find(int x) {
        if (x != pre[x]) {
            pre[x] = find(pre[x]);
        }
        return pre[x];
    }
}