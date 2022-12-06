package day141_150.day146.exercises1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/11/8
 * 1684. 统计一致字符串的数目
 */
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> characters = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            characters.add(allowed.charAt(i));
        }
        int res = 0;
        boolean flag;
        for (String word : words) {
            flag = true;
            for (int i = 0; i < word.length(); i++) {
                if (!characters.contains(word.charAt(i))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res++;
            }
        }
        return res;
    }
}
