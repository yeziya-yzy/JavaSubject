package day96.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/8/21
 * 1455. 检查单词是否为句中其他单词的前缀
 */
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (ifBeforeWord(words[i], searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }

    private boolean ifBeforeWord(String longString, String shortString) {
        if (longString.length() < shortString.length()) {
            return false;
        }
        for (int i = 0, j = 0; i < shortString.length(); i++, j++) {
            if (shortString.charAt(i) != longString.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
