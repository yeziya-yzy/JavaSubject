package day171_180.day171;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/12/13
 * 1832. 判断句子是否为全字母句
 * 简单
 */
class Solution {
    public boolean checkIfPangram(String sentence) {
        int count = 0;
        int[] ints = new int[26];
        for (int i = 0; i < sentence.length(); i++) {
            char charAt = sentence.charAt(i);
            if (charAt >= 'a' && charAt <= 'z') {
                if (ints[charAt - 'a'] == 0) {
                    ints[charAt - 'a']++;
                    count++;
                }
            } else {
                return false;
            }
        }
        return count == 26;
    }
}
