package day87.exercises1;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/8/11
 * 1417. 重新格式化字符串
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().reformat("covid2019"));
    }

    public String reformat(String s) {
        char[] chars = new char[s.length()];
        int charsIndex = 0;
        int sumNumber = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                ++sumNumber;
            }
        }
        boolean numberMore = false;
        if (Math.abs(2 * sumNumber - s.length()) >= 2) {
            return "";
        }
        if (2 * sumNumber > s.length()) {
            numberMore = true;
        }
        int numberIndex = 0;
        int letterIndex = 0;
        if (numberMore) {
            while (charsIndex < s.length() && numberIndex <= s.length() && letterIndex <= s.length()) {
                while (numberIndex < s.length() && !(s.charAt(numberIndex) >= '0' && s.charAt(numberIndex) <= '9')) {
                    numberIndex++;
                }
                chars[charsIndex++] = s.charAt(numberIndex);
                while (letterIndex < s.length() && !(s.charAt(letterIndex) >= 'a' && s.charAt(letterIndex) <= 'z')) {
                    letterIndex++;
                }
                if (charsIndex == s.length()) {
                    return new String(chars);
                }
                chars[charsIndex++] = s.charAt(letterIndex);
                numberIndex++;
                letterIndex++;
            }
        } else {
            while (charsIndex < s.length() && numberIndex <= s.length() && letterIndex <= s.length()) {
                while (numberIndex < s.length() && !(s.charAt(numberIndex) >= 'a' && s.charAt(numberIndex) <= 'z')) {
                    numberIndex++;
                }
                chars[charsIndex++] = s.charAt(numberIndex);
                while (letterIndex < s.length() && !(s.charAt(letterIndex) >= '0' && s.charAt(letterIndex) <= '9')) {
                    letterIndex++;
                }
                if (charsIndex == s.length()) {
                    return new String(chars);
                }
                chars[charsIndex++] = s.charAt(letterIndex);
                numberIndex++;
                letterIndex++;
            }
        }
        return new String(chars);
    }
}