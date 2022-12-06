package day101_110.day110.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/9/8
 * 1598. 文件夹操作日志搜集器
 */
class Solution {
    public int minOperations(String[] logs) {
        int res = 0;
        for (String log : logs) {
            if (log.equals("./")) {
                continue;
            }
            if (log.equals("../")) {
                if (res > 0) {
                    res--;
                }
            } else {
                res++;
            }
        }
        return res;
    }
}