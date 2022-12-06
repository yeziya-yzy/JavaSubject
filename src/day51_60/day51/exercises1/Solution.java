package day51.exercises1;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/6/7
 */
class Solution {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 5;
        System.out.println(new Solution().minEatingSpeed(piles, h));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int min = piles[0];
        int max = piles[0];
        for (int i = 1; i < piles.length; i++) {
            if (piles[i] < min) {
                min = piles[i];
            }
            if (piles[i] > max) {
                max = piles[i];
            }
        }
        int v = 1;
        int count;
        while (true) {
            count = 0;
            for (int i = 0; i < piles.length; i++) {
                if (piles[i] % v == 0) {
                    count = count + piles[i] / v;
                } else {
                    count = count + piles[i] / v + 1;
                }
            }
            if (count > h) {
                v++;
            } else {
                return v;
            }
        }
    }
}
