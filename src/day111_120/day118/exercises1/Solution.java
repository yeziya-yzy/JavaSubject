package day111_120.day118.exercises1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/9/25
 * 面试题 01.02. 判定是否互为字符重排
 */
class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> firstHashMap = new HashMap<>();
        Map<Character, Integer> secondHashMap = new HashMap<>();
        getInfo(s1, firstHashMap);
        getInfo(s2, secondHashMap);
        return ifTrue(firstHashMap, secondHashMap);
    }

    private void getInfo(String temp, Map<Character, Integer> map) {
        for (int i = 0; i < temp.length(); i++) {
            map.put(temp.charAt(i), map.getOrDefault(temp.charAt(i), 0) + 1);
        }
    }

    private boolean ifTrue(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        if (map1.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> characterIntegerEntry : map1.entrySet()) {
            if (!map2.containsKey(characterIntegerEntry.getKey())) {
                return false;
            }
            if (!map2.get(characterIntegerEntry.getKey()).equals(characterIntegerEntry.getValue())) {
                return false;
            }
        }
        return true;
    }
}
