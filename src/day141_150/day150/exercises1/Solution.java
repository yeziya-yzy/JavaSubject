package day141_150.day150.exercises1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/11/8
 * 791. 自定义字符串排序
 */
class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), ++count);
        }
        Character[] characters = new Character[s.length()];
        for (int i = 0; i < characters.length; i++) {
            characters[i] = s.charAt(i);
        }
        Arrays.sort(characters, Comparator.comparingInt(o -> map.getOrDefault(o, 0)));
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : characters) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }
}