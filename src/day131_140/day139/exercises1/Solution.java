package day131_140.day139.exercises1;


import java.util.List;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/10/23
 * 1773. 统计匹配检索规则的物品数量
 */
class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        if ("type".equals(ruleKey)) {
            for (List<String> item : items) {
                if (ruleValue.equals(item.get(0))) {
                    res++;
                }
            }
        } else if ("color".equals(ruleKey)) {
            for (List<String> item : items) {
                if (ruleValue.equals(item.get(1))) {
                    res++;
                }
            }
        } else if ("name".equals(ruleKey)) {
            for (List<String> item : items) {
                if (ruleValue.equals(item.get(2))) {
                    res++;
                }
            }
        }
        return res;
    }
}