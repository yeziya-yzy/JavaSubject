package day99.exercises1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/8/25
 * 658. 找到 K 个最接近的元素
 */
class Solution {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 1, 2, 3, 6, 7, 8, 9};
        int k = 9;
        int x = 4;
        List<Integer> closestElements = new Solution().findClosestElements(arr, k, x);
        for (Integer closestElement : closestElements) {
            System.out.print(closestElement + "\t");
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if (x < arr[0]) {
            for (int i = 0; i < k; i++) {
                res.add(arr[i]);
            }
            res.sort(null);
            return res;
        }
        if (x > arr[arr.length - 1]) {
            for (int i = arr.length - 1; i > arr.length - 1 - k; i--) {
                res.add(arr[i]);
            }
            res.sort(null);
            return res;
        }
        int indexRight = binarySearch(arr, x);
        int indexLeft = indexRight - 1;
        int sum = 0;
        while (sum < k) {
            if ((indexRight == arr.length && indexLeft >= 0) || (indexLeft >= 0 && indexRight < arr.length && Math.abs(arr[indexLeft] - x) <= Math.abs(arr[indexRight] - x))) {
                res.add(arr[indexLeft]);
                indexLeft--;
            } else if (indexLeft < 0 || (indexRight < arr.length && Math.abs(arr[indexLeft] - x) > Math.abs(arr[indexRight] - x))) {
                res.add(arr[indexRight]);
                indexRight++;
            }
            sum++;
        }
        res.sort(null);
        return res;
    }

    public int binarySearch(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
