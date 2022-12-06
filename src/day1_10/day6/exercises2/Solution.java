package day6.exercises2;

import day6.exercises2.ListNode;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/4/17
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
 * 案例:
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode headNode = new ListNode(0, head);
        ListNode left = headNode;
        ListNode right = headNode;
        for (int i = 0; i <= n; i++) {
            right = right.next;
        }
        while (right != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return headNode.next;
    }
}
