package day111_120.day113.exercises1;

import java.util.Arrays;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/9/14
 * 1619. 删除某些元素后的数组均值
 */
class Solution {
    public double trimMean(int[] arr) {
        int countDown = (int) (arr.length * 0.05);
        Arrays.sort(arr);
        int sum = 0;
        for (int i = countDown; i < arr.length - countDown; i++) {
            sum += arr[i];
        }
        return (double) sum / (arr.length - 2 * countDown);
    }
}
