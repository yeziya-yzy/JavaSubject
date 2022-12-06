package day111_120.day119.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/9/25
 * 面试题 17.09. 第 k 个数
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().getKthMagicNumber(13));
    }

    public int getKthMagicNumber(int k) {
        if (k <= 5) {
            return 2 * k - 1;
        }
        int res = 1;
        int[] numbers = {3, 5, 7};
        int group = (k - 1) / 3;
        if ((k - 1) % 3 == 0) {
            group--;
        }
        for (int i = 0; i < group; i++) {
            res = res * 3;
        }
        if ((k - 1) % 3 != 0) {
            res = res * numbers[(k - 1) % 3 - 1];
        } else {
            res = res * numbers[2];
        }
        return res;
    }
}