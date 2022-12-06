package day151_160.day151.exercises1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/11/15
 * 1710. 卡车上的最大单元数
 */
class Solution {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 3}, {2, 2}, {3, 1},
        };
        int maxSize = 4;
        System.out.println(new Solution().maximumUnits(arr, maxSize));
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(o -> -o[1]));
        int sum = 0;
        int theRest = truckSize;
        for (int[] boxType : boxTypes) {
            if (theRest - boxType[0] >= 0) {
                sum += boxType[0] * boxType[1];
                theRest -= boxType[0];
            } else {
                sum += theRest * boxType[1];
                return sum;
            }
        }
        return sum;
    }
}
