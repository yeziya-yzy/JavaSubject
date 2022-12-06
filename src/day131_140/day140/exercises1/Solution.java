package day131_140.day140.exercises1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/10/23
 * 784. 字母大小写全排列
 */
class Solution {
    public static void main(String[] args) {
        List<String> list = new Solution().letterCasePermutation("a1b2");
        list.forEach(System.out::println);
    }

    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isLetter(s.charAt(i))) {
                count++;
            }
        }
        String binaryString;
        int index;
        StringBuilder stringBuilder;
        StringBuilder needAdd;
        for (int i = 0; i < (1 << count); i++) {
            binaryString = Integer.toBinaryString(i);
            needAdd = new StringBuilder();
            if (binaryString.length() < count) {
                for (int j = 0; j < count - binaryString.length(); j++) {
                    needAdd.append("0");
                }
            }
            binaryString = needAdd.toString() + binaryString;
            index = 0;
            stringBuilder = new StringBuilder();
            char[] chars = s.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (isLetter(chars[j])) {
                    if (binaryString.charAt(index) == '1') {
                        chars[j] ^= (1 << 5);
                    }
                    index++;
                }
            }
            for (char aChar : chars) {
                stringBuilder.append(aChar);
            }
            res.add(stringBuilder.toString());
        }
        return res;
    }

    private boolean isLetter(char temp) {
        if (temp >= 'a' && temp <= 'z') {
            return true;
        }
        if (temp >= 'A' && temp <= 'Z') {
            return true;
        }
        return false;
    }
}