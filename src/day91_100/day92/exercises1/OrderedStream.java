package day92.exercises1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/8/16
 * 1656. 设计有序流
 */
class OrderedStream {
    private boolean[] booleans;
    private int index;
    private Map<Integer, String> values;

    public OrderedStream(int n) {
        index = 0;
        booleans = new boolean[n];
        values = new HashMap<>();
    }

    public List<String> insert(int idKey, String value) {
        List<String> res = new ArrayList<>();
        booleans[idKey - 1] = true;
        values.put(idKey, value);
        if (!booleans[index]) {
            return res;
        }
        while (index < booleans.length && booleans[index]) {
            res.add(values.get(index + 1));
            index++;
        }
        return res;
    }
}