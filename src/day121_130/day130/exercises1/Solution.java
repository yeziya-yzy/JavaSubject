package day121_130.day130.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/10/13
 * 769. 最多能完成排序的块
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxChunksToSorted(new int[]{4,3,2,1,0}));
    }
    public int maxChunksToSorted(int[] arr) {
        int m = 0, res = 0;
        for (int i = 0; i < arr.length; i++) {
            m = Math.max(m, arr[i]);
            if (m == i) {
                res++;
            }
        }
        return res;
    }
}
