package day111_120.day115.exercises1;

import java.util.*;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/9/19
 * 1636. 按照频率将数组升序排序
 */
class Solution {
    public static void main(String[] args) {
        int[] ints = new Solution().frequencySort(new int[]{-1,1,-6,4,5,-6,1,4,1});
        System.out.println(Arrays.toString(ints));
    }

    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] res = new int[nums.length];
        List<int[]> list = new ArrayList<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> item : hashMap.entrySet()) {
            list.add(new int[]{item.getKey(), item.getValue()});
        }
        Collections.sort(list, (a, b) -> a[1] - b[1] == 0 ? -(a[0] - b[0]) : a[1] - b[1]);
        int index = 0;
        for (int[] ints : list) {
            for (int i = 0; i < ints[1]; i++) {
                res[index] = ints[0];
                index++;
            }
        }
        return res;
    }
}
