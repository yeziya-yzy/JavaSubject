package day21.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/5/2
 */
class Solution {
    public static void main(String[] args) {
        int[] ints = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Solution().maxArea(ints));
    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        int indexLeft = 0;
        int indexRight = height.length - 1;
        while (indexRight != indexLeft) {
            maxArea = Math.max(maxArea, (indexRight - indexLeft) * Math.min(height[indexLeft], height[indexRight]));
            if (height[indexLeft] < height[indexRight]) {
                indexLeft++;
            } else {
                indexRight--;
            }
        }
        return maxArea;
    }
}
