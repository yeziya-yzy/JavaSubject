package day20.exercises3;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/5/1
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode temp = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = temp;
            temp = head;
            head = next;
        }
        return temp;
    }
}
