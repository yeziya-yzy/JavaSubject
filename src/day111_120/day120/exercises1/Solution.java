package day111_120.day120.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/9/25
 * 面试题 17.09. 第 k 个数
 */
class Solution {
    public String reformatNumber(String number) {
        String temp = number.replace(" ", "").replace("-", "");
        StringBuilder stringBuilder = new StringBuilder();
        int length = temp.length();
        int count = 0;
        if (length % 3 == 0 || length % 3 == 2) {
            for (int i = 0; i < length; i++) {
                stringBuilder.append(temp.charAt(i));
                count = count + 1;
                if (count % 3 == 0 && count != length) {
                    stringBuilder.append("-");
                }
            }
        } else {
            for (int i = 0; i < length - 4; i++) {
                stringBuilder.append(temp.charAt(i));
                count = count + 1;
                if (count % 3 == 0) {
                    stringBuilder.append("-");
                }
            }
            stringBuilder.append(temp, length - 4, length - 2);
            stringBuilder.append("-");
            stringBuilder.append(temp, length - 2, length);
        }
        return stringBuilder.toString();
    }
}