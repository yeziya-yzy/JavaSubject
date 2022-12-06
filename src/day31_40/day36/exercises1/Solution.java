package day36.exercises1;

import java.util.HashMap;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/5/17
 * 953. 验证外星语词典
 */
class Solution {
    HashMap<Character, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) {
        String[] words = {"apple", "app"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(new Solution().isAlienSorted(words, order));
    }

    public boolean isAlienSorted(String[] words, String order) {

        for (int i = 0; i < order.length(); i++) {
            hashMap.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; i++) {
            if (!bigger(words[i - 1], words[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean bigger(String left, String right) {
        if (left.length() > right.length() && left.contains(right)) {
            return false;
        }
        for (int i = 0; i < Math.min(left.length(), right.length()); i++) {
            if (hashMap.get(left.charAt(i)) > hashMap.get(right.charAt(i))) {
                return false;
            } else if (hashMap.get(left.charAt(i)) < hashMap.get(right.charAt(i))) {
                return true;
            }
        }
        return true;
    }
}
