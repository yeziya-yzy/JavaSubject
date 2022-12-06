package day141_150.day142.exercises1;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/10/31
 * 1662. 检查两个字符串数组是否相等
 */
class Solution {
    public static void main(String[] args) {
        String[] word1 = new String[]{
                "jbboxe", "yshcrtanrtlzyyp", "vudsssnzuef", "lde"
        };
        String[] word2 = new String[]{
                "jbboxeyshcrtanrt", "lzyypvudsssnzueflde"
        };
        System.out.println(new Solution().arrayStringsAreEqual(word1, word2));
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        for (String word : word1) {
            left.append(word);
        }
        for (String word : word2) {
            right.append(word);
        }
        return left.toString().equals(right.toString());
    }
}