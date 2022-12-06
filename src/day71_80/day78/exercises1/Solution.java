package day78.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/7/23
 * 1184. 公交站间的距离
 */
class Solution {
    public static void main(String[] args) {
        int[] distance = new int[]{
                1, 2, 3, 4
        };
        int start = 3;
        int destination = 0;
        System.out.println(new Solution().distanceBetweenBusStops(distance, start, destination));
    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int temp;
        if (start > destination) {
            temp = start;
            start = destination;
            destination = temp;
        }
        int n = distance.length;
        int res = 0;
        int sum = distance[destination];
        for (int i = start; i < destination; i++) {
            res += distance[i];
        }
        for (int i = (start - 1 + n) % n; i != destination; i = (i - 1 + n) % n) {
            sum += distance[i];
        }
        return Math.min(res, sum);
    }
}
