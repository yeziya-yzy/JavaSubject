package day171_180.day178;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/12/13
 * 2011. 执行操作后的变量值
 * 简单
 */
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (String operation : operations) {
            if (operation.equals("X++") || operation.equals("++X")) {
                res++;
            } else {
                res--;
            }
        }
        return res;
    }
}