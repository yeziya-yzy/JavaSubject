package day1.exercises2;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/4/11
 */
class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 7;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right + 1;
    }
}
