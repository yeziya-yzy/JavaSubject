package day111_120.day112.exercises1;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/9/12
 * 670. 最大交换
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maximumSwap(1993));
    }

    public int maximumSwap(int num) {
        String numString = String.valueOf(num);
        int max;
        int index;
        int temp;
        int res = 0;
        int[] ints = new int[numString.length()];
        for (int i = 0; i < numString.length(); i++) {
            ints[i] = numString.charAt(i) - 48;
        }
        for (int i = 0; i < ints.length; i++) {
            int[] maxFrom = getMaxFrom(ints, i);
            max = maxFrom[0];
            index = maxFrom[1];
            if (ints[i] != max) {
                temp = ints[i];
                ints[i] = ints[index];
                ints[index] = temp;
                for (int anInt : ints) {
                    res = res * 10 + anInt;
                }
                return res;
            }
        }
        return num;
    }

    private int[] getMaxFrom(int[] temp, int start) {
        int max = 0;
        int index = -1;
        for (int i = temp.length - 1; i >= start; i--) {
            if (temp[i] > max) {
                max = temp[i];
                index = i;
            }
        }
        return new int[]{max, index};
    }
}