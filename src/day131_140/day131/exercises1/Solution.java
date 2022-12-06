package day131_140.day131.exercises1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/10/15
 * 1441. 用栈操作构建数组
 */
class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int length = target.length;
        int index = 0;
        while (i < length) {
            if (i + 1 != target[index]) {
                res.add("Push");
                res.add("Pop");
            } else {
                res.add("Push");
                index++;
            }
            i++;
        }
        return res;
    }
}
