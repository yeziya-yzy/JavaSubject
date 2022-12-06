package day88.exercises1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/8/12
 * 1282. 用户分组
 */
class Solution {
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3});
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> aDefault = hashMap.getOrDefault(groupSizes[i], new ArrayList<>());
            aDefault.add(i);
            hashMap.put(groupSizes[i], aDefault);
        }
        Set<Integer> integers = hashMap.keySet();
        for (Integer integer : integers) {
            List<Integer> list = hashMap.get(integer);
            if (list.size() <= integer) {
                res.add(list);
            } else {
                for (int i = 0; i < list.size() / integer; i++) {
                    ArrayList<Integer> addList = new ArrayList<>();
                    for (int j = i * integer; j < (i + 1) * integer; j++) {
                        addList.add(list.get(j));
                    }
                    res.add(addList);
                }
            }
        }
        return res;
    }
}
