package day98.exercises1;

import java.util.*;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/8/24
 * 1460. 通过翻转子数组使两个数组相等
 */
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int length = target.length;
        Map<Integer, Integer> setTarget = new HashMap<>();
        Map<Integer, Integer> setArr = new HashMap<>();
        for (int i = 0; i < length; i++) {
            setTarget.put(target[i], setTarget.getOrDefault(target[i], 0) + 1);
            setArr.put(arr[i], setArr.getOrDefault(arr[i], 0) + 1);
        }
        if (setTarget.size() != setArr.size()) {
            return false;
        }
        Set<Integer> set = setTarget.keySet();
        for (Integer integer : set) {
            if (!setArr.containsKey(integer) || !setArr.get(integer).equals(setTarget.get(integer))) {
                return false;
            }
        }
        return true;
    }
}
