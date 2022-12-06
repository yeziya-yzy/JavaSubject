package day60.exercises1;

import java.util.*;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/6/19
 * 508. 出现次数最多的子树元素和
 */
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        getAllNumber(root);
        Set<Integer> integers = map.keySet();
        List<Integer> list = new ArrayList<>();
        for (Integer integer : integers) {
            if (map.get(integer) == max) {
                list.add(integer);
            }
        }
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }

    private int getAllNumber(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val + getAllNumber(root.left) + getAllNumber(root.right);
        int count = map.getOrDefault(sum, 0) + 1;
        map.put(sum, count);
        max = Math.max(max, count);
        return sum;
    }
}
