package day5.exercises8;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/4/14
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 示例
 * 输入：s = "Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * <p>
 * 输入： s = "God Ding"
 * 输出："doG gniD"
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {
        char[] charsTo = new char[s.length()];
        int index;
        int charsToIndex = 0;
        for (int i = 0; i <= s.length(); i++) {
            if (i == s.length() || s.charAt(i) == ' ') {
                index = i - 1;
                while (index >= 0 && s.charAt(index) != ' ') {
                    charsTo[charsToIndex] = s.charAt(index);
                    index--;
                    charsToIndex++;
                }
                if (charsToIndex < s.length()) {
                    charsTo[charsToIndex] = ' ';
                    charsToIndex++;
                }
            }
        }
        return String.valueOf(charsTo);
    }
}
