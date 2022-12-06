package day33.exercises1;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/5/14
 * 148. 排序链表ListNode
 */
class Solution {
    public ListNode sortList(ListNode head) {
        return sortListNode(head, null);
    }

    private ListNode sortListNode(ListNode head, ListNode tail) {
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
        ListNode list1 = sortListNode(head, mid);
        ListNode list2 = sortListNode(mid, tail);
        return mergeListNode(list1, list2);
    }

    private ListNode mergeListNode(ListNode left, ListNode right) {
        ListNode listNode = new ListNode();
        ListNode temp = listNode;
        while (left != null && right != null) {
            if (left.val < right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        temp.next = left != null ? left : right;
        return listNode.next;
    }
}
