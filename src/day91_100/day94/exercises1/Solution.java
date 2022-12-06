package day94.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/8/19
 * 1450. 在既定时间做作业的学生人数
 */
class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        int length = startTime.length;
        for (int i = 0; i < length; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                res++;
            }
        }
        return res;
    }
}
