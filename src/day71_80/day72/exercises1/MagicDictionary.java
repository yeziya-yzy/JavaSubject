package day72.exercises1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/7/11
 * 676. 实现一个魔法字典
 */
class MagicDictionary {
    List<String> list;

    public MagicDictionary() {
        list = new ArrayList<>();
    }

    public void buildDict(String[] dictionary) {
        list.addAll(Arrays.asList(dictionary));
    }

    public boolean search(String searchWord) {
        for (String item : list) {
            if (can(item, searchWord)) {
                return true;
            }
        }
        return false;
    }

    private boolean can(String s1, String s2) {
        if (Math.abs(s1.length() - s2.length()) >= 2) {
            return false;
        }
        String left;
        String right;
        if (s1.length() <= s2.length()) {
            left = s1;
            right = s2;
        } else {
            left = s2;
            right = s1;
        }
        int leftIndex = 0;
        int rightIndex = 0;
        if (left.length() == right.length()) {
            int count = 0;
            for (int i = 0; i < left.length(); i++) {
                if (left.charAt(i) != right.charAt(rightIndex)) {
                    count++;
                }
                rightIndex++;
            }
            return count == 1;
        }
        while (leftIndex < left.length() && rightIndex < right.length()) {
            if (left.charAt(leftIndex) == right.charAt(rightIndex)) {
                leftIndex++;
            }
            rightIndex++;
        }
        return (leftIndex - rightIndex) == 1;
    }
}
