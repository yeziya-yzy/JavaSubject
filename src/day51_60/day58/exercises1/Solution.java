package day58.exercises1;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/6/17
 * 1089. 复写零
 */
class Solution {
    public void duplicateZeros(int[] arr) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                queue.add(arr[i]);
            } else {
                queue.add(0);
                queue.add(0);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = queue.poll();
        }
    }
}
