package day68.exercises1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/7/4
 */
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        int best = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n - 1; ++i) {
            int delta = arr[i + 1] - arr[i];
            if (delta < best) {
                best = delta;
                ans.clear();
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i + 1]);
                ans.add(pair);
            } else if (delta == best) {
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i + 1]);
                ans.add(pair);
            }
        }

        return ans;
    }
}
