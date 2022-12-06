package day39.exercises1;

import java.util.Random;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/5/21
 * 961. 在长度 2N 的数组中找出重复 N 次的元素
 */
class Solution {
    public int repeatedNTimes(int[] nums) {
        Random r = new Random();
        int len = nums.length;
        int a, b;
        while (true) {
            a = r.nextInt(len);
            b = r.nextInt(len);
            if (a != b && nums[a] == nums[b]) {
                return nums[a];
            }
        }
    }
}
