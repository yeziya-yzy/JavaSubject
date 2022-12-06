package WeeklyCompetition.week1.exercise1;

import java.util.Arrays;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/8/29
 * 6160. 和有限的最长子序列
 */
class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] ints = new int[queries.length];
        for (int i = 0; i < ints.length; i++) {
            int sum = 0;
            int count = 0;
            for (int num : nums) {
                if (sum + num <= queries[i]) {
                    sum += num;
                    count++;
                }
            }
            ints[i] = count;
        }
        return ints;
    }
}
