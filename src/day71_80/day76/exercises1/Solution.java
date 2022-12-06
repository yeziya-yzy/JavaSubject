package day76.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/7/17
 * 565. 数组嵌套
 */
class Solution {
    public int arrayNesting(int[] nums) {
        boolean[] booleans = new boolean[nums.length];
        int max = 0;
        int count;
        for (int i = 0; i < nums.length; i++) {
            count = 0;
            while (!booleans[i]) {
                booleans[i] = true;
                i = nums[i];
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
