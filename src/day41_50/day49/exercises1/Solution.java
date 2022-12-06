package day49.exercises1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/6/4
 */
class Solution {
    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(new Solution().numUniqueEmails(emails));
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for (String email : emails) {
            int i = email.indexOf('@');
            String local = email.substring(0, i).split("\\+")[0]; // 去掉本地名第一个加号之后的部分
            local = local.replace(".", ""); // 去掉本地名中所有的句点
            emailSet.add(local + email.substring(i));
        }
        return emailSet.size();
    }
}
