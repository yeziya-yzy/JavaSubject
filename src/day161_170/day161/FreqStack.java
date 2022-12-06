package day161_170.day161;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/11/30
 * 895. 最大频率栈
 */
class FreqStack {
    //元素出现次数
    private Map<Integer, Integer> freq;
    //元素出现次数对应的栈
    private Map<Integer, Deque<Integer>> group;
    //最大出现次数
    private int maxFreq;

    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        //设置出现次数加1
        freq.put(val, freq.getOrDefault(val, 0) + 1);
        //如果出现次数的栈没有栈就新建一个
        group.putIfAbsent(freq.get(val), new ArrayDeque<>());
        //放到出现次数的栈中
        group.get(freq.get(val)).push(val);
        //设置最大出现次数
        maxFreq = Math.max(maxFreq, freq.get(val));
    }

    public int pop() {
        //最大出现次数的栈得到最大出现次数的数
        int res = group.get(maxFreq).pop();
        //次数 -1
        freq.put(res, freq.get(res) - 1);
        //最大出现次数的栈为空,最大出现次数-1
        if (group.get(maxFreq).isEmpty()) {
            maxFreq--;
        }
        return res;
    }
}
