package day171_180.day173;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/12/13
 * 1785. 构成特定和需要添加的最少元素
 * 中等
 */
class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long abs = Math.abs(goal - sum);
        return (int) (abs / limit + (abs % limit == 0 ? 0 : 1));
    }
}