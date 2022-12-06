package day111_120.day116.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/9/24
 * 1652. 拆炸弹
 */
class Solution {
    public int[] decrypt(int[] code, int k) {
        int length = code.length;
        int[] res = new int[length];
        if (k == 0) {
            return res;
        }
        if (k > 0) {
            for (int i = 0; i < length; i++) {
                int sum = 0;
                for (int j = i + 1; j < i + k + 1; j++) {
                    sum += code[j % length];
                }
                res[i] = sum;
            }
        } else {
            k = -k;
            for (int i = 0; i < length; i++) {
                int sum = 0;
                for (int j = i - 1; j > i - k - 1; j--) {
                    sum += code[(j + length) % length];
                }
                res[i] = sum;
            }
        }
        return res;
    }
}