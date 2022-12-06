package day7.exercises1;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/4/18
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 */
public class Solution {
    public static void main(String[] args) {
        String s = "a1";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> strings = new HashSet<>();
        int len = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                strings.remove(s.charAt(i - 1));
            }
            while (j < s.length() && !strings.contains(s.charAt(j))) {
                strings.add(s.charAt(j));
                j++;
            }
            len = Math.max(j - i, len);
        }
        return len;
    }
}
