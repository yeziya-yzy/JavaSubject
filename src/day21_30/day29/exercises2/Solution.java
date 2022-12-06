package day29.exercises2;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/5/10
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
class Solution {
    public static void main(String[] args) {
        String s = "aacabdkacaa";
        System.out.println(new Solution().longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        int maxSize = 0;
        int n = s.length();
        boolean flag = true;
        boolean[][] booleans = new boolean[n][n];
        String returnString = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                if (isPalindrome(s.substring(i, j))) {
                    if (j - i > maxSize) {
                        maxSize = j - i;
                        returnString = s.substring(i, j);
                    }
                }
            }
        }
        return returnString;
    }

    private boolean isPalindrome(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return true;
        }
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return isPalindrome(s.substring(1, s.length() - 1));
        } else {
            return false;
        }
    }
}