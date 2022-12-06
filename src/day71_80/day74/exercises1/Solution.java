package day74.exercises1;


import java.util.*;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/7/13
 * 735. 行星碰撞
 */
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            boolean isLive = true;
            while (isLive && !stack.isEmpty() && stack.peek() > 0) {
                isLive = stack.peek() < -asteroid;
                if (stack.peek() <= -asteroid) {
                    stack.pop();
                }
            }
            if (isLive) {
                stack.push(asteroid);
            }
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}