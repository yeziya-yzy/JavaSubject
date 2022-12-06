package day52.exercises1;

import java.util.Random;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/6/9
 * 497. 非重叠矩形中的随机点
 */
class Solution {
    private final int[][] rects;
    private final Random random = new Random();

    public Solution(int[][] rects) {
        this.rects = rects;
    }

    public int[] pick() {
        int[] rect = rects[random.nextInt(rects.length)];
        int x = (int) (Math.random() * (rect[2] - rect[0] + 1)) + rect[0];
        int y = (int) (Math.random() * (rect[3] - rect[1] + 1)) + rect[1];
        return new int[]{x, y};
    }
}
