package day111_120.day117.exercises1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/9/25
 * 788. 旋转数字
 */
class Solution {
    public int rotatedDigits(int n) {
        Map<Character, Character> tempMap = new HashMap<>();
        tempMap.put('0', '0');
        tempMap.put('1', '1');
        tempMap.put('8', '8');
        tempMap.put('2', '5');
        tempMap.put('5', '2');
        tempMap.put('6', '9');
        tempMap.put('9', '6');
        int res = 0;
        for (int i = 1; i <= n; i++) {
            String number = String.valueOf(i);
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < number.length(); j++) {
                if (!tempMap.containsKey(number.charAt(j))) {
                    break;
                }
                stringBuilder.append(tempMap.get(number.charAt(j)));
            }
            if (stringBuilder.length() != number.length()) {
                continue;
            }
            if (Integer.parseInt(stringBuilder.toString()) != i) {
                res++;
            }
        }
        return res;
    }
}
