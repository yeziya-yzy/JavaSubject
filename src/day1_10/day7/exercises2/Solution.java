package day7.exercises2;

import java.util.Arrays;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/4/18
 * 给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串。
 * 案例:
 * <p>
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * <p>
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 */
public class Solution {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "a";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int[] intS1 = new int[26];
        int[] intS2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            intS1[s1.charAt(i) - 97] += 1;
            intS2[s2.charAt(i) - 97] += 1;
        }
        if (Arrays.equals(intS1, intS2)) {
            return true;
        }
        for (int i = s1.length() - 1; i < s2.length() - 1; i++) {
            intS2[s2.charAt(i + 1) - 97] += 1;
            intS2[s2.charAt(i - s1.length() + 1) - 97] -= 1;
            if (Arrays.equals(intS1, intS2)) {
                return true;
            }
        }
        return false;
    }
}
