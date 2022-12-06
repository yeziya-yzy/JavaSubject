package day141_150.day143.exercises1;

import java.util.*;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/10/31
 * 1620. 网络信号最好的坐标
 */
class Solution {

    private int[] power;

    public static void main(String[] args) {
        int[][] ints = new int[][]{
                {0, 1, 2}, {2, 1, 2}, {1, 0, 2}, {1, 2, 2}
        };
        int radius = 1;
        System.out.println(Arrays.toString(new Solution().bestCoordinate(ints, radius)));
    }

    public int[] bestCoordinate(int[][] towers, int radius) {
        power = new int[towers.length];
        for (int i = 0; i < power.length; i++) {
            power[i] = towers[i][2];
        }
        for (int i = 0; i < towers.length; i++) {
            add(towers, i, radius);
        }
        int max = 0;
        for (int[] tower : towers) {
            max = Math.max(max, tower[2]);
        }
        List<int[]> ints = new ArrayList<>();
        for (int[] tower : towers) {
            if (tower[2] == max) {
                ints.add(tower);
            }
        }
        ints.sort((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        if (ints.get(0)[2] == 0) {
            return new int[]{0, 0};
        }
        int[] res = new int[2];
        res[0] = ints.get(0)[0];
        res[1] = ints.get(0)[1];
        ints = null;
        return res;
    }

    private void add(int[][] towers, int where, int radius) {
        int[] tower = towers[where];
        for (int i = 0; i < towers.length; i++) {
            if (i != where) {
                int dist = countDist(towers[i], tower);
                if (dist < radius * radius) {
                    int powerAdd = (int) (power[where] / (1 + Math.sqrt(dist)));
                    towers[i][2] += powerAdd;
                }
            }
        }
    }

    private int countDist(int[] left, int[] right) {
        int x2 = (left[0] - right[0]) * (left[0] - right[0]);
        int y2 = (left[1] - right[1]) * (left[1] - right[1]);
        return x2 + y2;
    }
}