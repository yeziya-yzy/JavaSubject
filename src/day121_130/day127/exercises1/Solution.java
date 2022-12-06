package day121_130.day127.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/10/3
 * 856. 括号的分数
 */
class Solution {
    public int scoreOfParentheses(String s) {
        if (s.equals("()")) {
            return 1;
        }
        int tempLen = 0;
        for (int i = 0; i < s.length(); i++) {
            tempLen += (s.charAt(i) == '(' ? 1 : -1);
            if (tempLen == 0) {
                tempLen = i + 1;
                break;
            }
        }
        if (tempLen == s.length()) {
            return 2 * scoreOfParentheses(s.substring(1, s.length() - 1));
        } else {
            return scoreOfParentheses(s.substring(0, tempLen)) + scoreOfParentheses(s.substring(tempLen));
        }
    }
}