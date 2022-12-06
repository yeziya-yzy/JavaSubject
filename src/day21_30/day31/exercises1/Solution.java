package day31.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/5/12
 * 944. 删列造序
 */
class Solution {
    public static void main(String[] args) {
        String[] str = {"zyx", "wvu", "tsr"};
        System.out.println(new Solution().minDeletionSize(str));
    }

    public int minDeletionSize(String[] strs) {
        int number = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    number++;
                    break;
                }
            }
        }
        return number;
    }
}
