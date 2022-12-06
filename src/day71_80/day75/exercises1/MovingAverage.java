package day75.exercises1;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/7/16
 */
class MovingAverage {
    Queue<Integer> queue;
    int size;
    double sum;

    public MovingAverage(int size) {
        queue = new ArrayDeque<>();
        this.size = size;
        sum = 0;
    }

    public double next(int val) {
        if (queue.size() == size) {
            sum -= queue.poll();
        }
        queue.offer(val);
        sum += val;
        return sum / queue.size();
    }
}