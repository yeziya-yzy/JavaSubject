package day14.exercises3;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/4/23
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode right = head;
        ListNode left = head;
        while (right != null && left != null && right.next != null) {
            left = left.next;
            right = right.next.next;
            if (left == right) {
                return true;
            }
        }
        return false;
    }
}