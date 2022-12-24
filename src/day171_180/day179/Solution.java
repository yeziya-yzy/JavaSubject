package day171_180.day179;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/12/13
 * 1754. 构造字典序最大的合并字符串
 * 中等
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().largestMerge("abcabc", "abdcaba"));
    }

    public String largestMerge(String word1, String word2) {
        char[] charsWord1 = word1.toCharArray();
        char[] charsWord2 = word2.toCharArray();
        int left = 0;
        int right = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (left < charsWord1.length && right < charsWord2.length) {
            if (getBiggerArr(charsWord1, left, charsWord2, right)) {
                stringBuilder.append(charsWord1[left]);
                left++;
            } else {
                stringBuilder.append(charsWord2[right]);
                right++;
            }
        }
        while (left < charsWord1.length) {
            stringBuilder.append(charsWord1[left]);
            left++;
        }
        while (right < charsWord2.length) {
            stringBuilder.append(charsWord2[right]);
            right++;
        }
        return stringBuilder.toString();
    }

    private boolean getBiggerArr(char[] left, int leftIndex, char[] right, int rightIndex) {
        int leftTemp = leftIndex;
        int rightTemp = rightIndex;
        while (leftTemp < left.length && rightTemp < right.length) {
            if (left[leftTemp] < right[rightTemp]) {
                return false;
            }
            if (left[leftTemp] > right[rightTemp]) {
                return true;
            }
            leftTemp++;
            rightTemp++;
        }
        return leftTemp < left.length - leftIndex;
    }
}