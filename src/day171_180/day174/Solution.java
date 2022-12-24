package day171_180.day174;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/12/13
 * 1785. 构成特定和需要添加的最少元素
 * 中等
 */
class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length && k < groups.length; ) {
            if (canMatch(groups[k], nums, i)) {
                i += groups[k].length;
                k++;
            } else {
                i++;
            }
        }
        return k == groups.length;
    }

    private boolean canMatch(int[] group, int[] nums, int k) {
        if (group.length + k > nums.length) {
            return false;
        }
        for (int i = 0; i < group.length; i++) {
            if (group[i] != nums[k + i]) {
                return false;
            }
        }
        return true;
    }
}