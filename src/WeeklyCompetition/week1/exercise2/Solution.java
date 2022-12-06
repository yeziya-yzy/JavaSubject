package WeeklyCompetition.week1.exercise2;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/8/29
 * 2390. 从字符串中移除星号
 */
class Solution {
    public String removeStars(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int index = s.length() - 1;
        int count = 0;
        while (index >= 0) {
            char temp = s.charAt(index);
            if (temp != '*') {
                if (count > 0) {
                    count--;
                    index--;
                    continue;
                }
                stringBuilder.append(temp);
            } else {
                count++;
            }
            index--;
        }
        return stringBuilder.reverse().toString();
    }
}