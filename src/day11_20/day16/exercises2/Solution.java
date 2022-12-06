package day16.exercises2;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/4/27
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表。
 */
public class Solution {
    public static void main(String[] args) {
        int[] ints = new int[]{
                4, 19, 14, 5, -3, 1, 8, 5, 11, 15
        };
        ListNode listNode = new ListNode(ints[0]);
        ListNode temp;
        ListNode index = listNode;
        for (int i = 1; i < ints.length; i++) {
            temp = new ListNode(ints[i]);
            index.next = temp;
            index = temp;
        }
        ListNode listNodeNew = new Solution().sortList(listNode);
        while (listNodeNew != null) {
            System.out.println(listNodeNew.val);
            listNodeNew = listNodeNew.next;
        }
    }

    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        return merge(list1, list2);
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        temp.next = temp1 != null ? temp1 : temp2;
        return dummyHead.next;
    }
}
