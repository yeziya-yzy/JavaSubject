package day121_130.day121.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/10/3
 * 1784. 检查二进制字符串字段
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().checkOnesSegment("1100111"));
    }

    public boolean checkOnesSegment(String s) {
        int index = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) == '1') {
                index = i;
                break;
            }
        }
        for (int i = 0; i <= index; i++) {
            if (s.charAt(i) == '0') {
                return false;
            }
        }
        return true;
    }
}