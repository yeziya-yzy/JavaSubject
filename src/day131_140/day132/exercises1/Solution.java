package day131_140.day132.exercises1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/10/15
 * 904. 水果成篮
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().totalFruit(new int[]{
                1, 2, 3, 2, 2
        }));
    }

    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> cnt = new HashMap<>();

        int left = 0, ans = 0;
        for (int right = 0; right < n; ++right) {
            cnt.put(fruits[right], cnt.getOrDefault(fruits[right], 0) + 1);
            while (cnt.size() > 2) {
                cnt.put(fruits[left], cnt.get(fruits[left]) - 1);
                if (cnt.get(fruits[left]) == 0) {
                    cnt.remove(fruits[left]);
                }
                ++left;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}