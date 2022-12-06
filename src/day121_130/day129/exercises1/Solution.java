package day121_130.day129.exercises1;


import java.util.HashSet;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/10/3
 * 817. 链表组件
 */
class Solution {
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> temp = new HashSet<>();
        for (int num : nums) {
            temp.add(num);
        }
        boolean flag = false;
        int count = 0;
        ListNode listNode = head;
        while (listNode != null) {
            if (temp.contains(listNode.val)) {
                if (!flag) {
                    count++;
                }
                flag = true;
            } else {
                flag = false;
            }
            listNode = listNode.next;
        }
        return count;
    }
}