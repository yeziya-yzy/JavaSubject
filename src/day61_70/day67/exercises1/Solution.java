package day67.exercises1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/7/3
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().nextGreaterElement(12));
    }

    public int nextGreaterElement(int n) {
        String number = String.valueOf(n);
        Character[] ints = new Character[number.length()];
        for (int i = 0; i < number.length(); i++) {
            ints[i] = number.charAt(i);
        }
        Arrays.sort(ints, Comparator.comparingInt(character -> -character));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            stringBuilder.append(ints[i]);
        }
        Integer res = Integer.parseInt(stringBuilder.toString());
        if (res.equals(n)) {
            return -1;
        }
        return res;
    }
}