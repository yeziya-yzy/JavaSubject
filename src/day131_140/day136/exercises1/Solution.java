package day131_140.day136.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/10/23
 * 1768. 交替合并字符串
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().mergeAlternately("123214", "987654"));
    
    }
    public String mergeAlternately(String word1, String word2) {
        int indexWordLeft = 0;
        int indexWordRight = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (indexWordLeft < word1.length() && indexWordRight < word2.length()) {
            stringBuilder.append(word1.charAt(indexWordLeft++));
            stringBuilder.append(word2.charAt(indexWordRight++));
        }
        while (indexWordLeft < word1.length()) {
            stringBuilder.append(word1.charAt(indexWordLeft++));
        }
        while (indexWordRight < word2.length()) {
            stringBuilder.append(word2.charAt(indexWordRight++));
        }
        return stringBuilder.toString();
    }
}
