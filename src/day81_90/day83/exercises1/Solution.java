package day83.exercises1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/8/6
 * 1408. 数组中的字符串匹配
 */
class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    ret.add(words[i]);
                    break;
                }
            }
        }
        return ret;
    }
}
