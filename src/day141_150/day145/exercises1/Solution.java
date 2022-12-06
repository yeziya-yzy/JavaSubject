package day141_150.day145.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/10/31
 * 1678. 设计 Goal 解析器
 */
class Solution {
    public String interpret(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }
}