package day10.exercises3;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/4/21
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 案例:
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * <p>
 * 输入：lists = []
 * 输出：[]
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        ListNode mergeLeft = merge(lists, l, mid);
        ListNode mergeRight = merge(lists, mid + 1, r);
        return mergeTwoLists(mergeLeft, mergeRight);
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode head = new ListNode();
        ListNode headNew = head;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                headNew.next = a;
                a = a.next;
            } else {
                headNew.next = b;
                b = b.next;
            }
            headNew = headNew.next;
        }
        headNew.next = a == null ? b : a;
        return head.next;
    }
}
