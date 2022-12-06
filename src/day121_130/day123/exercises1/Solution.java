package day121_130.day123.exercises1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/10/3
 * 811. 子域名访问计数
 */
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> temp = new HashMap<>();
        for (String cpDomain : cpdomains) {
            int count = Integer.parseInt(cpDomain.split(" ")[0]);
            String doMainString = cpDomain.split(" ")[1];
            String[] domainNames = doMainString.split("\\.");
            StringBuilder domainName = new StringBuilder();
            for (int i = domainNames.length - 1; i >= 0; i--) {
                if (i != domainNames.length - 1) {
                    domainName.insert(0, ".");
                }
                domainName.insert(0, domainNames[i]);
                temp.put(domainName.toString(), temp.getOrDefault(domainName.toString(), 0) + count);
            }
        }
        ArrayList<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }
}