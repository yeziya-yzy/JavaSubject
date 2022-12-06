package day30.exercises2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/5/11
 * 438. 找到字符串中所有字母异位词
 */
class Solution {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        new Solution().findAnagrams(s, p).forEach(System.out::println);
    }

    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        int[] pInt = new int[26];
        int[] sInt = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pInt[p.charAt(i) - 97]++;
        }
        for (int i = 0; i < p.length(); i++) {
            sInt[s.charAt(i) - 97]++;
        }
        if (Arrays.equals(pInt, sInt)) {
            list.add(0);
        }
        for (int i = 1; i < s.length() - p.length() + 1; i++) {
            sInt[s.charAt(i + p.length() - 1) - 97]++;
            sInt[s.charAt(i - 1) - 97]--;
            if (Arrays.equals(pInt, sInt)) {
                list.add(i);
            }
        }
        return list;
    }
}