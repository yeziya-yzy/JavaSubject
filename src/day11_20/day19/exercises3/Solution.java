package day19.exercises3;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/4/30
 * Jump Game
 * 有n块石头分别在x轴的0,1....n-1的位置
 * 一只青蛙在石头0,想跳到石头n-1
 * 如果青蛙在第i块石头上,它最多可以向右跳a[i]
 * 请问青蛙是否能跳到石头n-1
 */
public class Solution {
    public static void main(String[] args) {
        int[] ints = {
                2, 3, 1, 1, 4
        };
        System.out.println(new Solution().canGet(ints));
    }

    public boolean canGet(int[] a) {
        boolean[] booleans = new boolean[a.length];
        booleans[0] = true;
        for (int i = 1; i < a.length; i++) {
            booleans[i] = false;
            for (int j = 0; j < i; j++) {
                if (booleans[j] && j + a[j] >= i) {
                    booleans[i] = true;
                    break;
                }
            }
        }
        return booleans[a.length - 1];
    }
}
