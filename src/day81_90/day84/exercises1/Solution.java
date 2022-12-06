package day84.exercises1;

import java.util.*;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/8/7
 * 636. 函数的独占时间
 */
class Solution {
    public static void main(String[] args) {
        int n = 2;
        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("1:start:2");
        logs.add("1:end:5");
        logs.add("0:end:6");
        System.out.println(Arrays.toString(new Solution().exclusiveTime(n, logs)));
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<int[]> stack = new ArrayDeque<>(); // {idx, 开始运行的时间}
        int[] res = new int[n];
        for (String log : logs) {
            int idx = Integer.parseInt(log.substring(0, log.indexOf(':')));
            String type = log.substring(log.indexOf(':') + 1, log.lastIndexOf(':'));
            int timestamp = Integer.parseInt(log.substring(log.lastIndexOf(':') + 1));
            if ("start".equals(type)) {
                if (!stack.isEmpty()) {
                    res[stack.peek()[0]] += timestamp - stack.peek()[1];
                    stack.peek()[1] = timestamp;
                }
                stack.push(new int[]{idx, timestamp});
            } else {
                int[] t = stack.pop();
                res[t[0]] += timestamp - t[1] + 1;
                if (!stack.isEmpty()) {
                    stack.peek()[1] = timestamp + 1;
                }
            }
        }
        return res;
    }
}