package day92.exercises2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/8/16
 * 3. 无重复字符的最长子串
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        Set<Character> set = new HashSet<>();
        int res = 0;
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (index < length && !set.contains(s.charAt(index))) {
                set.add(s.charAt(index));
                index++;
            }
            res = Math.max(res, index - i);
        }
        return res;
    }
}
