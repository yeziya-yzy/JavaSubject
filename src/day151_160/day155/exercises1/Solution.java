package day151_160.day155.exercises1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/11/19
 * 1742. 盒子中小球的最大数量
 */
class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>(46);
        int max = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = 0;
            char[] numbers = String.valueOf(i).toCharArray();
            for (char number : numbers) {
                sum += number - 48;
            }
            int addNumber = map.getOrDefault(sum, 0) + 1;
            max = Math.max(max, addNumber);
            map.put(sum, addNumber);
        }
        return max;
    }
}