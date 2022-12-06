package day12.exercises2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/4/23
 * 给你两个单链表的头节点headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * 图示两个链表在节点 c1 开始相交：
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode headATemp = headA;
        ListNode headBTemp = headB;
        Map<ListNode, Integer> map = new HashMap<>();
        while (headATemp != null) {
            map.put(headATemp, headATemp.val);
            headATemp = headATemp.next;
        }
        while (headBTemp != null) {
            if (map.containsKey(headBTemp)) {
                return headBTemp;
            }
            headBTemp = headBTemp.next;
        }
        return null;
    }
}
