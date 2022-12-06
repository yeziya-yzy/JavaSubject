package day62.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/6/21
 * 1108. IP 地址无效化
 */
class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
}
