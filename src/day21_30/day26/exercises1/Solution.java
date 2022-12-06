package day26.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/5/7
 * 433. 最小基因变化
 */
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        String temp = "";
        boolean flag = false;
        int count = 0;
        for (String s : bank) {
            if (s.equals(end)) {
                temp = end;
                flag = true;
                break;
            }
        }
        if (!flag) {
            return -1;
        }
        int indexStart = 0;
        int indexTemp = 0;
        while (indexStart < start.length()) {
            if (start.charAt(indexStart) != temp.charAt(indexTemp)) {
                count++;
            }
            indexTemp++;
            indexStart++;
        }
        return count;
    }
}
