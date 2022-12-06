package day54.exercises1;

import java.util.*;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/6/12
 * 890. 查找和替换模式
 */
class Solution {
    public static void main(String[] args) {
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        List<String> andReplacePattern = new Solution().findAndReplacePattern(words, pattern);
        for (String s : andReplacePattern) {
            System.out.println(s);
        }
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (match(word, pattern)) {
                list.add(word);
            }
        }
        return list;
    }

    private boolean match(String word, String pattern) {
        Map<Character, Character> mapLeft = new HashMap<>();
        Map<Character, Character> mapRight = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char left = word.charAt(i);
            char right = pattern.charAt(i);
            if (!mapLeft.containsKey(left)) {
                mapLeft.put(left, right);
            } else if (mapLeft.get(left) != right) {
                return false;
            }
            if (!mapRight.containsKey(right)) {
                mapRight.put(right, left);
            } else if (mapRight.get(right) != left) {
                return false;
            }
        }
        return true;
    }
}
