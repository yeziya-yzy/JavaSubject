package day161_170.day170;


import java.util.*;
import java.util.stream.Stream;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/12/12
 * 1781. 所有子字符串美丽值之和
 * 中等
 */
class Solution {
    public int beautySum(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] cnt = new int[26];
            int maxFreq = 0;
            for (int j = i; j < s.length(); j++) {
                int charWhere = s.charAt(j) - 'a';
                cnt[charWhere]++;
                maxFreq = Math.max(maxFreq, cnt[charWhere]);
                int minFreq = s.length();
                for (int k = 0; k < 26; k++) {
                    if (cnt[k] > 0) {
                        minFreq = Math.min(minFreq, cnt[k]);
                    }
                }
                res += maxFreq - minFreq;
            }
        }
        return res;
    }
}