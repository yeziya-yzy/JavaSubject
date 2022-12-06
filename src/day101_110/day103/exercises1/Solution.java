package day101_110.day103.exercises1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/8/29
 * 998. 最大二叉树 II
 * 946. 验证栈序列
 */
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = pushed.length;
        for (int i = 0, j = 0; i < n; ++i) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}