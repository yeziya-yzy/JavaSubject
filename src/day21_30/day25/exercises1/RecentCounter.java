package day25.exercises1;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/5/6
 */
class RecentCounter {
    Queue<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.add(t);
        Delete(queue, t);
        return queue.size();
    }

    private void Delete(Queue<Integer> queue, int time) {
        while (!queue.isEmpty() && queue.peek() < time - 3000) {
            queue.poll();
        }
    }
}
