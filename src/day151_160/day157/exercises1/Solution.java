package day151_160.day157.exercises1;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/11/19
 * 809. 情感丰富的文字
 */
class Solution {
    public int expressiveWords(String s, String[] words) {
        int count = 0;  
        for (String word : words) {
            if (canChange(word, s)) {
                count++;
            }
        }
        return count;
    }

    private boolean canChange(String left, String right) {
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < left.length() && rightIndex < right.length()) {
            if (left.charAt(leftIndex) != right.charAt(rightIndex)) {
                return false;
            }
            char needEquals = left.charAt(leftIndex);
            int leftLength = 0;
            int rightLength = 0;
            while (leftIndex < left.length() && left.charAt(leftIndex) == needEquals) {
                leftLength++;
                leftIndex++;
            }
            while (rightIndex < right.length() && right.charAt(rightIndex) == needEquals) {
                rightLength++;
                rightIndex++;
            }
            if (leftLength > rightLength) {
                return false;
            }
            if (leftLength != rightLength && rightLength < 3) {
                return false;
            }
        }
        //如果一个遍历完毕了,另一个还没遍历说明也是不行的
        // "abcd"
        // "abc"
        return leftIndex == left.length() && rightIndex == right.length();
    }
}