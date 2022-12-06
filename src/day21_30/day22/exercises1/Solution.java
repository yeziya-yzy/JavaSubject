package day22.exercises1;

import java.util.Arrays;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/5/3
 */
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (s, t1) -> {
            char c = s.charAt(s.length() - 1);
            char c1 = t1.charAt(t1.length() - 1);
            if (c >= '0' && c <= '9' && c1 >= '0' && c1 <= '9') {
                return 0;
            } else if (c >= '0' && c <= '9') {
                return 1;
            } else if (c1 >= '0' && c1 <= '9') {
                return -1;
            }
            String[] s1 = s.split(" ", 2);
            String[] t11 = t1.split(" ", 2);
            if (s1[1].compareTo(t11[1]) != 0) {
                return s1[1].compareTo(t11[1]);
            }
            return s1[0].compareTo(t11[0]);
        });
        return logs;
    }
}
