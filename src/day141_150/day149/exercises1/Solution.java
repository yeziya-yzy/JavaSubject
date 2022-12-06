package day141_150.day149.exercises1;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/11/8
 * 1704. 判断字符串的两半是否相似
 */
class Solution {
    public boolean halvesAreAlike(String s) {
        int length = s.length();
        String left = s.substring(0, length / 2);   
        String right = s.substring(length / 2);
        String vowelString = "aeiouAEIOU";
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < left.length(); i++) {
            if (vowelString.indexOf(left.charAt(i)) >= 0) {
                leftCount++;
            }
        }
        for (int i = 0; i < right.length(); i++) {
            if (vowelString.indexOf(right.charAt(i)) >= 0) {
                rightCount++;
            }
        }
        return rightCount == leftCount;
    }

}
