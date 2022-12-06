package day77.exercises2;


import java.util.*;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/7/18
 * 2342. 数位和相等数对的最大和
 */
class Solution {
    public static void main(String[] args) {
        int[] ints = {
                383, 77, 97, 261, 102, 344, 150, 130, 55, 337, 401, 498, 21, 5
        };
        System.out.println(new Solution().maximumSum(ints));
    }

    public int maximumSum(int[] nums) {
        Map<Integer, Integer> temp = new HashMap<>();
        List<Integer> arrayList = new ArrayList<>();
        int max = -1;
        int sum;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            String number = String.valueOf(nums[i]);
            for (int j = 0; j < number.length(); j++) {
                sum += Integer.parseInt(String.valueOf(number.charAt(j)));
            }
            arrayList.add(sum);
            if (!temp.containsKey(sum)) {
                temp.put(sum, i);
            } else {
                if (nums[i] > nums[temp.get(sum)]) {
                    temp.put(sum, i);
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (temp.containsKey(arrayList.get(i)) && temp.get(arrayList.get(i)) != i) {
                max = Math.max(max, nums[temp.get(arrayList.get(i))] + nums[i]);
            }
        }
        return max;
    }
}